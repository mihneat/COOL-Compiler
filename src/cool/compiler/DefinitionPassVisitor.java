package cool.compiler;

import cool.structures.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DefinitionPassVisitor implements ASTVisitor<Void> {
    Scope currentScope = SymbolTable.globals;
    Map<String, ArrayList<TypeSymbol>> unresolvedParents = new HashMap<>();

    @Override
    public Void visit(Program program) {
        currentScope = SymbolTable.globals;

        for (var cls : program.classes) {
            cls.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Class class_) {
        var name = class_.name;
        var parentName = class_.parent;

        var typeSymbol = new TypeSymbol(name.token.getText(), SymbolTable.OBJECT);

        // Algorithm:
        //
        // Look up the class symbol in the global namespace
        // If it's found, return a "class redefined" error
        // If it's not:
        //  - create the class (already done?)
        //  - check the 'unresolvedClasses' map and add the current
        //       class as parent to all the ones in the returned list
        //  - remove the current class from the dictionary
        //  - check if the parent class has already been defined
        //    - if it has NOT, add a new entry in the dictionary

        // Error handling
        // Check if the name is illegal
        if (Objects.equals(name.token.getText(), SymbolTable.SELF_TYPE_STR)) {
            SymbolTable.error(name.ctx, name.token, "Class has illegal name SELF_TYPE");
            return null;
        }

        // Check if the class has already been defined
        if (SymbolTable.globals.lookup(name.token.getText()) != null) {
            SymbolTable.error(name.ctx, name.token, "Class " + name.token.getText() + " is redefined");
            return null;
        }

        // Add the class to the global namespace
        SymbolTable.globals.add(typeSymbol);

        // Check if any classes inherit the current one
        if (unresolvedParents.containsKey(name.token.getText())) {
            for (var child: unresolvedParents.get(name.token.getText())) {
                child.setParent(typeSymbol);
            }
        }

        // Remove the class from the map
        unresolvedParents.remove(name.token.getText());

        if (class_.parent != null) {
            // Check if the parent is an illegal type
            switch (parentName.token.getText()) {
                case SymbolTable.STRING_STR , SymbolTable.INT_STR, SymbolTable.BOOL_STR, SymbolTable.SELF_TYPE_STR -> {
                    SymbolTable.error(parentName.ctx, parentName.token, "Class " + name.token.getText() + " has illegal parent " + parentName.token.getText());
                    return null;
                }
            }

            // If the parent class has been defined, use it as parent
            if (SymbolTable.globals.lookup(parentName.token.getText()) != null) {
                typeSymbol.setParent((TypeSymbol) SymbolTable.globals.lookup(parentName.token.getText()));
            } else {
                if (!unresolvedParents.containsKey(parentName.token.getText())) {
                    unresolvedParents.put(parentName.token.getText(), new ArrayList<>());
                }

                var list = unresolvedParents.get(parentName.token.getText());
                list.add(typeSymbol);
            }
        }

        // Move into the new scope
        currentScope = typeSymbol;

        name.setTypeSymbol(typeSymbol);

        if (class_.definitions != null) {
            for (var def : class_.definitions) {
                def.accept(this);
            }
        }

        currentScope = typeSymbol.getParent();
        return null;
    }

    @Override
    public Void visit(Attribute attribute) {
        TypeSymbol baseClass = (TypeSymbol)currentScope;
        Variable name = attribute.name;

        var idSymbol = new IdSymbol(name.token.getText());

        // Error handling
        if (Objects.equals(name.token.getText(), "self")) {
            SymbolTable.error(name.ctx, name.token, "Class " + baseClass.getName() + " has attribute with illegal name self");
            return null;
        }

        if (!currentScope.add(idSymbol)) {
            SymbolTable.error(name.ctx, name.token, "Class " + baseClass.getName() + " redefines attribute " + name.token.getText());
            return null;
        }

        name.setSymbol(idSymbol);
        name.setScope(currentScope);

        if (attribute.init != null) {
            attribute.init.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Method method) {
        TypeSymbol baseClass = (TypeSymbol)currentScope;
        Variable name = method.name;

        FunctionSymbol functionSymbol = new FunctionSymbol(name.token.getText(), currentScope);
        functionSymbol.setTypeStr(method.type.token.getText());

        // Error handling
        if (!currentScope.add(functionSymbol)) {
            SymbolTable.error(name.ctx, name.token, "Class " + baseClass.getName() + " redefines method " + name.token.getText());
            return null;
        }

        // Move into the new scope
        currentScope = functionSymbol;

        name.setSymbol(functionSymbol);
        name.setScope(currentScope);

        if (method.params != null) {
            for (var param : method.params) {
                param.accept(this);
            }
        }

        method.body.accept(this);

        currentScope = currentScope.getParent();
        return null;
    }

    @Override
    public Void visit(Formal formal) {
        TypeSymbol baseClass = (TypeSymbol)currentScope.getParent();
        FunctionSymbol baseMethod = (FunctionSymbol)currentScope;
        Variable name = formal.name;
        Type type = formal.type;


        IdSymbol idSymbol = new IdSymbol(name.token.getText());
        idSymbol.setTypeStr(type.token.getText());
        idSymbol.setFormal();

        // Error handling
        // Check if the formal is called 'self'
        if (name.token.getText().equals("self")) {
            SymbolTable.error(name.ctx, name.token, "Method " + baseMethod.getName() + " of class " + baseClass.getName() + " has formal parameter with illegal name self");
            return null;
        }

        // Check if the formal is redefined
        if (!currentScope.add(idSymbol)) {
            SymbolTable.error(name.ctx, name.token, "Method " + baseMethod.getName() + " of class " + baseClass.getName() + " redefines formal parameter " + name.token.getText());
            return null;
        }

        // Check if the type is SELF_TYPE
        if (type.token.getText().equals(SymbolTable.SELF_TYPE_STR)) {
            SymbolTable.error(type.ctx, type.token, "Method " + baseMethod.getName() + " of class " + baseClass.getName() + " has formal parameter " + name.token.getText() + " with illegal type SELF_TYPE");
            return null;
        }

        name.setSymbol(idSymbol);
        name.setScope(currentScope);

        return null;
    }

    @Override
    public Void visit(LocalAttribute localAttribute) {
        Variable name = localAttribute.name;

        LocalAttributeSymbol localAttributeSymbol = new LocalAttributeSymbol(name.token.getText(), currentScope);

        // Error handling
        // Check if the local attribute is called 'self'
        if (name.token.getText().equals("self")) {
            SymbolTable.error(name.ctx, name.token, "Let variable has illegal name self");
            return null;
        }

        if (localAttribute.init != null) {
            localAttribute.init.accept(this);
        }

        // Move into the new scope
        currentScope = localAttributeSymbol;

        name.setSymbol(localAttributeSymbol);
        name.setScope(currentScope);

        return null;
    }

    @Override
    public Void visit(BinaryOperation binaryOperation) {
        binaryOperation.left.accept(this);
        binaryOperation.right.accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryOperation unaryOperation) {
        unaryOperation.operand.accept(this);
        return null;
    }

    @Override
    public Void visit(Assignment assignment) {
        assignment.name.accept(this);
        assignment.value.accept(this);
        return null;
    }

    @Override
    public Void visit(New new_) {
        new_.type.accept(this);
        return null;
    }

    @Override
    public Void visit(ExplicitDispatch explicitDispatch) {
        explicitDispatch.method.setScope(currentScope);

        explicitDispatch.obj.accept(this);

        if (explicitDispatch.params != null) {
            for (var param : explicitDispatch.params) {
                param.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(ImplicitDispatch implicitDispatch) {
        // Instead of going further into the variable, we're stopping here and setting the symbol and scope
        // Going further would make it difficult to distinguish between a variable and a method
        implicitDispatch.method.setScope(currentScope);

        if (implicitDispatch.params != null) {
            for (var param : implicitDispatch.params) {
                param.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(If if_) {
        if_.cond.accept(this);
        if_.then.accept(this);
        if_.else_.accept(this);
        return null;
    }

    @Override
    public Void visit(While while_) {
        while_.cond.accept(this);
        while_.body.accept(this);
        return null;
    }

    @Override
    public Void visit(Let let) {
        for (var def : let.defs) {
            def.accept(this);
        }
        let.body.accept(this);

        // Restore the scope
        for (var def : let.defs) {
            currentScope = currentScope.getParent();
        }

        return null;
    }

    @Override
    public Void visit(Case case_) {
        case_.expr.accept(this);
        for (var branch : case_.branches) {
            branch.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(CaseBranch caseBranch) {
        Variable name = caseBranch.name;
        Type type = caseBranch.type;

        LocalAttributeSymbol caseBranchSymbol = new LocalAttributeSymbol(name.token.getText(), currentScope);

        // Error handling
        // Check if the case attribute is called 'self'
        if (name.token.getText().equals("self")) {
            SymbolTable.error(name.ctx, name.token, "Case variable has illegal name self");
            return null;
        }

        // Check if the type is SELF_TYPE
        if (type.token.getText().equals(SymbolTable.SELF_TYPE_STR)) {
            SymbolTable.error(type.ctx, type.token, "Case variable " + name.token.getText() + " has illegal type SELF_TYPE");
            return null;
        }

        // Move into the new scope
        currentScope = caseBranchSymbol;

        name.setSymbol(caseBranchSymbol);
        name.setScope(currentScope);

        caseBranch.body.accept(this);

        currentScope = currentScope.getParent();
        return null;
    }

    @Override
    public Void visit(Block block) {
        for (var expr : block.expressions) {
            expr.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Int int_) {
        return null;
    }

    @Override
    public Void visit(String_ string) {
        return null;
    }

    @Override
    public Void visit(Bool bool) {
        return null;
    }

    @Override
    public Void visit(Type type) {
        return null;
    }

    @Override
    public Void visit(Variable variable) {
        variable.setScope(currentScope);
        return null;
    }
}
