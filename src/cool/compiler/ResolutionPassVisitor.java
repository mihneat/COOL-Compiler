package cool.compiler;

import cool.structures.*;

import java.util.Iterator;

public class ResolutionPassVisitor implements ASTVisitor<TypeSymbol> {
    TypeSymbol currentClass = null;

    @Override
    public TypeSymbol visit(Program program) {
        // Check if a class 'Main' with the function 'main()' exists
        TypeSymbol mainClass = (TypeSymbol)SymbolTable.globals.lookup("Main");
        if (mainClass == null) {
            // No program context because of a missing file name in ProgramContext, no idea why
            SymbolTable.error("No method main in class Main");
            return null;
        }

        FunctionSymbol mainFn = mainClass.lookupMethod("main");
        if (mainFn == null) {
            SymbolTable.error("No method main in class Main");
            return null;
        }

        // Check if the main() method has any formals
        if (mainFn.getFormals() != null && mainFn.getFormals().size() > 0) {
            SymbolTable.error("No method main in class Main");
            return null;
        }

        for (var cls : program.classes) {
            cls.accept(this);
            currentClass = null;
        }

        return null;
    }

    @Override
    public TypeSymbol visit(Class class_) {
        var name = class_.name;
        var parent = class_.parent;

        // If the class had an error on the first pass, skip the class
        if (name.getTypeSymbol() == null) {
            return null;
        }

        currentClass = name.getTypeSymbol();

        // Check if the parent exists in the global namespace
        if (class_.parent != null) {
            if (SymbolTable.globals.lookup(parent.token.getText()) == null) {
                SymbolTable.error(parent.ctx, parent.token, "Class " + name.token.getText() + " has undefined parent " + parent.token.getText());
                return null;
            }
        }

        // Check if there is an inheritance loop
        if (Utils.checkInheritanceLoop(name.getTypeSymbol())) {
            SymbolTable.error(name.ctx, name.token, "Inheritance cycle for class " + name.token.getText());
            return null;
        }

        if (class_.definitions != null) {
            for (var def : class_.definitions) {
                def.accept(this);
            }
        }

        return null;
    }

    @Override
    public TypeSymbol visit(Attribute attribute) {
        Variable name = attribute.name;
        Type type = attribute.type;

        // If the attribute had an error during the first pass, skip it
        if (name.getSymbol() == null) {
            return null;
        }

        TypeSymbol baseClass = (TypeSymbol)name.getScope();

        // Error handling
        // Check if a parent class has already declared the attribute
        if (name.getScope().getParent().lookup(name.token.getText()) != null) {
            SymbolTable.error(name.ctx, name.token, "Class " + baseClass.getName() + " redefines inherited attribute " + name.token.getText());
            return null;
        }

        // Check if the type exists in the namespace
        TypeSymbol typeSymbol = (TypeSymbol)SymbolTable.globals.lookup(type.token.getText());
        if (typeSymbol == null) {
            SymbolTable.error(type.ctx, type.token, "Class " + baseClass.getName() + " has attribute " + name.token.getText() + " with undefined type " + type.token.getText());
            return null;
        }

        // Set the type
        name.getSymbol().setType(typeSymbol);

        if (attribute.init != null) {
            TypeSymbol initType = attribute.init.accept(this);
            if (initType == null) {
                return null;
            }

            if (Utils.getDistanceFromParent_checkSelfType(currentClass, initType, typeSymbol) < 0) {
                SymbolTable.error(attribute.init.ctx, attribute.init.token, "Type " + initType.getName() + " of initialization expression of attribute " + name.token.getText() + " is incompatible with declared type " + typeSymbol.getName());
            }
        }

        return null;
    }

    @Override
    public TypeSymbol visit(Method method) {
        Variable name = method.name;
        Type type = method.type;

        // If the method had an error during the first pass, skip it
        if (name.getSymbol() == null) {
            return null;
        }

        TypeSymbol baseClass = (TypeSymbol)name.getScope().getParent();

        // Error handling
        // Check if the type exists in the namespace
        TypeSymbol typeSymbol = (TypeSymbol)SymbolTable.globals.lookup(type.token.getText());
        if (typeSymbol == null) {
            SymbolTable.error(type.ctx, type.token, "Class " + baseClass.getName() + " has method " + name.token.getText() + " with undefined return type " + type.token.getText());
            return null;
        }

        // Set the type
        name.getSymbol().setType(typeSymbol);

        if (method.params != null) {
            for (var param : method.params) {
                param.accept(this);
            }
        }

        // Error handling AFTER typing the formals
        // Check if the function is being overridden incorrectly
        FunctionSymbol parentMethod = ((TypeSymbol) baseClass.getParent()).lookupMethod(name.token.getText());
        if (parentMethod != null) {
            // Check if formals count is different
            if (method.params.size() != parentMethod.getFormals().size()) {
                SymbolTable.error(name.ctx, name.token, "Class " + baseClass.getName() + " overrides method " + name.token.getText() + " with different number of formal parameters");
                return null;
            }

            // Check if any formals change their type
            Iterator<Formal> methodIt = method.params.iterator();
            for (var parentFormal : parentMethod.getFormals().entrySet()) {
                Formal formal = methodIt.next();
                TypeSymbol parentType = ((IdSymbol)parentFormal.getValue()).getType();

                // If the formal had an error, skip it
                if (parentType == null) {
                    continue;
                }

                if (!formal.type.token.getText().equals(parentType.getName())) {
                    SymbolTable.error(formal.type.ctx, formal.type.token, "Class " + baseClass.getName() + " overrides method " + name.token.getText() + " but changes type of formal parameter " + formal.name.token.getText() + " from " + parentType.getName() + " to " + formal.type.token.getText());
                    return null;
                }
            }

            // Check if return type is different
            if (!method.type.token.getText().equals(parentMethod.getType().getName())) {
                SymbolTable.error(method.type.ctx, method.type.token, "Class " + baseClass.getName() + " overrides method " + name.token.getText() + " but changes return type from " + parentMethod.getType().getName() + " to " + method.type.token.getText());
                return null;
            }
        }

        TypeSymbol bodyType = method.body.accept(this);
        if (bodyType == null) {
            return null;
        }

        if (Utils.getDistanceFromParent_checkSelfType(currentClass, bodyType, typeSymbol) < 0) {
            SymbolTable.error(method.body.ctx, method.body.token, "Type " + bodyType.getName() + " of the body of method " + name.token.getText() + " is incompatible with declared return type " + typeSymbol.getName());

        }

        return null;
    }

    @Override
    public TypeSymbol visit(Formal formal) {
        Variable name = formal.name;
        Type type = formal.type;

        // If the formal parameter had an error during the first pass, skip it
        if (name.getSymbol() == null) {
            return null;
        }

        TypeSymbol baseClass = (TypeSymbol)name.getScope().getParent();
        FunctionSymbol baseMethod = (FunctionSymbol)name.getScope();

        // Error handling
        // Check if the type exists in the namespace
        TypeSymbol typeSymbol = (TypeSymbol)SymbolTable.globals.lookup(type.token.getText());
        if (typeSymbol == null) {
            SymbolTable.error(type.ctx, type.token, "Method " + baseMethod.getName() + " of class " + baseClass.getName() + " has formal parameter " + name.token.getText() + " with undefined type " + type.token.getText());
            return null;
        }

        name.getSymbol().setType(typeSymbol);

        return null;
    }

    @Override
    public TypeSymbol visit(LocalAttribute localAttribute) {
        Variable name = localAttribute.name;
        Type type = localAttribute.type;

        // If the formal parameter had an error during the first pass, skip it
        if (name.getSymbol() == null) {
            return null;
        }

        // Error handling
        // Check if the type exists in the namespace
        TypeSymbol typeSymbol = (TypeSymbol)SymbolTable.globals.lookup(type.token.getText());
        if (typeSymbol == null) {
            SymbolTable.error(type.ctx, type.token, "Let variable " + name.token.getText() + " has undefined type " + type.token.getText());
            return null;
        }

        name.getSymbol().setType(typeSymbol);

        if (localAttribute.init != null) {
            TypeSymbol initType = localAttribute.init.accept(this);
            if (initType == null) {
                return null;
            }

            if (Utils.getDistanceFromParent_checkSelfType(currentClass, initType, typeSymbol) < 0) {
                SymbolTable.error(localAttribute.init.ctx, localAttribute.init.token, "Type " + initType.getName() + " of initialization expression of identifier " + name.token.getText() + " is incompatible with declared type " + typeSymbol.getName());
            }
        }

        return null;
    }

    @Override
    public TypeSymbol visit(BinaryOperation binaryOperation) {
        // Get the operand types
        TypeSymbol leftType = binaryOperation.left.accept(this);
        TypeSymbol rightType = binaryOperation.right.accept(this);

        if (binaryOperation.token.getText().equals("=")) {
            // Stop error propagation
            if (leftType == null || rightType == null) {
                return SymbolTable.BOOL;
            }

            // Check if primitive type and same type
            if ((leftType == SymbolTable.INT || leftType == SymbolTable.STRING || leftType == SymbolTable.BOOL) && (leftType != rightType)) {
                SymbolTable.error(binaryOperation.ctx, binaryOperation.token, "Cannot compare " + leftType.getName() + " with " + rightType.getName());
            }

            return SymbolTable.BOOL;
        }

        // Change the return type based on the operator
        TypeSymbol returnType = SymbolTable.INT;
        if (binaryOperation.token.getText().equals("<") || binaryOperation.token.getText().equals("<=")) {
            returnType = SymbolTable.BOOL;
        }

        // Stop error propagation
        if (leftType == null || rightType == null) {
            return returnType;
        }

        if (leftType != SymbolTable.INT) {
            SymbolTable.error(binaryOperation.left.ctx, binaryOperation.left.token, "Operand of " + binaryOperation.token.getText() + " has type " + leftType.getName() + " instead of Int");
        }

        if (rightType != SymbolTable.INT) {
            SymbolTable.error(binaryOperation.right.ctx, binaryOperation.right.token, "Operand of " + binaryOperation.token.getText() + " has type " + rightType.getName() + " instead of Int");
        }

        return returnType;
    }

    @Override
    public TypeSymbol visit(UnaryOperation unaryOperation) {
        // If the operator is 'isvoid' return Bool
        if (unaryOperation.token.getText().equalsIgnoreCase("isvoid")) {
            return SymbolTable.BOOL;
        }

        // Get the operand type
        TypeSymbol operandType = unaryOperation.operand.accept(this);
        if (unaryOperation.token.getText().equalsIgnoreCase("not")) {
            // Stop error propagation
            if (operandType == null) {
                return SymbolTable.BOOL;
            }

            // Check bool type
            if (operandType != SymbolTable.BOOL) {
                SymbolTable.error(unaryOperation.operand.ctx, unaryOperation.operand.token, "Operand of not has type " + operandType.getName() + " instead of Bool");
            }

            return SymbolTable.BOOL;
        }

        // Stop error propagation
        if (operandType == null) {
            return SymbolTable.INT;
        }

        if (operandType != SymbolTable.INT) {
            SymbolTable.error(unaryOperation.operand.ctx, unaryOperation.operand.token, "Operand of " + unaryOperation.token.getText() + " has type " + operandType.getName() + " instead of Int");
        }

        return SymbolTable.INT;
    }

    @Override
    public TypeSymbol visit(Assignment assignment) {
        TypeSymbol varType = assignment.name.accept(this);
        TypeSymbol exprType = assignment.value.accept(this);

        // Stop error propagation
        if (varType == null || exprType == null) {
            return null;
        }

        // System.out.println(varType.getName() + " vs " + exprType.getName());

        // Check if identifier is 'self'
        if (assignment.name.token.getText().equals("self")) {
            SymbolTable.error(assignment.name.ctx, assignment.name.token, "Cannot assign to self");
            return null;
        }

        // Check if varType is a parent of exprType
        if (Utils.getDistanceFromParent_checkSelfType(currentClass, exprType, varType) < 0) {
            SymbolTable.error(assignment.value.ctx, assignment.value.token, "Type " + exprType.getName() + " of assigned expression is incompatible with declared type " + varType.getName() + " of identifier " + assignment.name.token.getText());
            return null;
        }

        return varType;
    }

    @Override
    public TypeSymbol visit(New new_) {
        Type type = new_.type;

        TypeSymbol typeSymbol = (TypeSymbol)SymbolTable.globals.lookup(type.token.getText());
        if (typeSymbol == null) {
            SymbolTable.error(type.ctx, type.token, "new is used with undefined type " + type.token.getText());
            return null;
        }

        return typeSymbol;
    }

    @Override
    public TypeSymbol visit(ExplicitDispatch explicitDispatch) {
        Variable methodName = explicitDispatch.method;
        TypeSymbol baseClass = null;
        TypeSymbol staticTypeSymbol = null;

        TypeSymbol objType = explicitDispatch.obj.accept(this);
        if (objType == null) {
            return null;
        }

        explicitDispatch.obj.setType(objType);

        if (explicitDispatch.staticType != null) {
            Type staticType = explicitDispatch.staticType;

            // Error handling
            // Static type should not be SELF_TYPE
            if (staticType.token.getText().equals(SymbolTable.SELF_TYPE_STR)) {
                SymbolTable.error(staticType.ctx, staticType.token, "Type of static dispatch cannot be SELF_TYPE");
                return null;
            }

            // Static type should exist in the namespace
            staticTypeSymbol = (TypeSymbol) SymbolTable.globals.lookup(staticType.token.getText());
            if (staticTypeSymbol == null) {
                SymbolTable.error(staticType.ctx, staticType.token, "Type " + staticType.token.getText() + " of static dispatch is undefined");
                return null;
            }

            // Check if the 'obj' 's class is a child of the static type
            if (Utils.getDistanceFromParent_checkSelfType(currentClass, objType, staticTypeSymbol) < 0) {
                SymbolTable.error(staticType.ctx, staticType.token, "Type " + staticType.token.getText() + " of static dispatch is not a superclass of type " + objType.getName());
                return null;
            }

            staticType.setTypeSymbol(staticTypeSymbol);
            baseClass = staticTypeSymbol;
        } else {
            // Set the base class as the type of the expression
            baseClass = objType;

            // Check for SELF_TYPE
            if (objType == SymbolTable.SELF_TYPE) {
                baseClass = Utils.findBaseClass(methodName.getScope());
            }
        }

        // Check if the method exists in the current scope
        FunctionSymbol methodFn = baseClass.lookupMethod(methodName.token.getText());
        if (methodFn == null) {
            SymbolTable.error(methodName.ctx, methodName.token, "Undefined method " + methodName.token.getText() + " in class " + baseClass.getName());
            return null;
        }

        // Check param count
        int paramCount = (explicitDispatch.params == null) ? 0 : explicitDispatch.params.size();
        if (methodFn.getFormals().size() != paramCount) {
            SymbolTable.error(methodName.ctx, methodName.token, "Method " + methodName.token.getText() + " of class " + baseClass.getName() + " is applied to wrong number of arguments");
            return null;
        }

        if (explicitDispatch.params != null) {
            var paramsIt = explicitDispatch.params.iterator();
            for (var formalParam : methodFn.getFormals().values()) {
                // Get the types
                Expression param = paramsIt.next();
                TypeSymbol paramType = param.accept(this);

                // Due to only using 2 passes, this is a bit uglier than it should. I'm looking for each formal parameter's
                // type in the global namespace, if it exists, and THEN I'm doing the comparison. Normally, the type of the formal
                // should be retrievable from the symbol, however, the formal param types are resolved during this pass, meaning
                // some formal params might not yet have a resolved type, due to forward referencing
                TypeSymbol formalParamType = (TypeSymbol) SymbolTable.globals.lookup(((IdSymbol)formalParam).getTypeStr());
                if (formalParamType == null) {
                    continue;
                }

                if (Utils.getDistanceFromParent_checkSelfType(currentClass, paramType, formalParamType) < 0) {
                    SymbolTable.error(param.ctx, param.token, "In call to method " + methodName.token.getText() + " of class " + baseClass.getName() + ", actual type " + paramType.getName() + " of formal parameter " + formalParam.getName() + " is incompatible with declared type " + formalParamType.getName());
                }
            }
        }

        // Establish the method return type
        TypeSymbol returnType;

        if (methodFn.getTypeStr().equals(SymbolTable.SELF_TYPE_STR)) {
            returnType = objType;
        } else {
            returnType = (TypeSymbol) SymbolTable.globals.lookup(methodFn.getTypeStr());
        }

        return returnType;
    }

    @Override
    public TypeSymbol visit(ImplicitDispatch implicitDispatch) {
        Variable methodName = implicitDispatch.method;

        // Get the base class
        TypeSymbol baseClass = Utils.findBaseClass(methodName.getScope());
        if (baseClass == null) {
            return null;
        }

        // Check if the method exists in the current scope
        FunctionSymbol methodFn = baseClass.lookupMethod(methodName.token.getText());
        if (methodFn == null) {
            SymbolTable.error(methodName.ctx, methodName.token, "Undefined method " + methodName.token.getText() + " in class " + baseClass.getName());
            return null;
        }

        // Check param count
        int paramCount = (implicitDispatch.params == null) ? 0 : implicitDispatch.params.size();
        if (methodFn.getFormals().size() != paramCount) {
            SymbolTable.error(methodName.ctx, methodName.token, "Method " + methodName.token.getText() + " of class " + baseClass.getName() + " is applied to wrong number of arguments");
            return null;
        }

        if (implicitDispatch.params != null) {
            var paramsIt = implicitDispatch.params.iterator();
            for (var formalParam : methodFn.getFormals().values()) {
                // Get the types
                Expression param = paramsIt.next();
                TypeSymbol paramType = param.accept(this);
                TypeSymbol formalParamType = (TypeSymbol) SymbolTable.globals.lookup(((IdSymbol)formalParam).getTypeStr());
                if (formalParamType == null) {
                    continue;
                }

                if (Utils.getDistanceFromParent_checkSelfType(currentClass, paramType, formalParamType) < 0) {
                    SymbolTable.error(param.ctx, param.token, "In call to method " + methodName.token.getText() + " of class " + baseClass.getName() + ", actual type " + paramType.getName() + " of formal parameter " + formalParam.getName() + " is incompatible with declared type " + formalParamType.getName());
                }
            }
        }

        // Establish the method return type
//        TypeSymbol returnType;
//
//        if (methodFn.getTypeStr().equals(SymbolTable.SELF_TYPE_STR)) {
//            returnType = baseClass;
//        } else {
//            returnType = (TypeSymbol) SymbolTable.globals.lookup(methodFn.getTypeStr());
//        }

        return (TypeSymbol) SymbolTable.globals.lookup(methodFn.getTypeStr());
    }

    @Override
    public TypeSymbol visit(If if_) {
        TypeSymbol condType = if_.cond.accept(this);
        if (condType != SymbolTable.BOOL) {
            SymbolTable.error(if_.cond.ctx, if_.cond.token, "If condition has type " + condType.getName() + " instead of Bool");
        }

        TypeSymbol thenType = if_.then.accept(this);
        TypeSymbol elseType = if_.else_.accept(this);

        return Utils.lowestCommonAncestor_checkSelfType(currentClass, thenType, elseType);
    }

    @Override
    public TypeSymbol visit(While while_) {
        TypeSymbol condType = while_.cond.accept(this);
        if (condType != SymbolTable.BOOL) {
            SymbolTable.error(while_.cond.ctx, while_.cond.token, "While condition has type " + condType.getName() + " instead of Bool");
        }

        while_.body.accept(this);
        return SymbolTable.OBJECT;
    }

    @Override
    public TypeSymbol visit(Let let) {
        for (var def : let.defs) {
            def.accept(this);
        }

        return let.body.accept(this);
    }

    @Override
    public TypeSymbol visit(Case case_) {
        TypeSymbol exprType = case_.expr.accept(this);
        if (exprType == null) {
            return null;
        }

        TypeSymbol branchLca = null;
        for (var branch : case_.branches) {
            TypeSymbol branchType = branch.accept(this);
            if (branchType == null) {
                continue;
            }

            if (branchLca == null) {
                branchLca = branchType;
                continue;
            }

            branchLca = Utils.lowestCommonAncestor(branchLca, branchType);
        }

        return branchLca;
    }

    @Override
    public TypeSymbol visit(CaseBranch caseBranch) {
        Variable name = caseBranch.name;
        Type type = caseBranch.type;

        // If the formal parameter had an error during the first pass, skip it
        if (name.getSymbol() == null) {
            return null;
        }

        // Error handling
        // Check if the type exists in the namespace
        TypeSymbol typeSymbol = (TypeSymbol)SymbolTable.globals.lookup(type.token.getText());
        if (typeSymbol == null) {
            SymbolTable.error(type.ctx, type.token, "Case variable " + name.token.getText() + " has undefined type " + type.token.getText());
            return null;
        }

        caseBranch.name.getSymbol().setType(typeSymbol);

        return caseBranch.body.accept(this);
    }

    @Override
    public TypeSymbol visit(Block block) {
        TypeSymbol returnType = null;
        for (var expr : block.expressions) {
            returnType = expr.accept(this);
        }

        return returnType;
    }

    @Override
    public TypeSymbol visit(Int int_) {
        return SymbolTable.INT;
    }

    @Override
    public TypeSymbol visit(String_ string) {
        return SymbolTable.STRING;
    }

    @Override
    public TypeSymbol visit(Bool bool) {
        return SymbolTable.BOOL;
    }

    @Override
    public TypeSymbol visit(Type type) {
        return type.getTypeSymbol();
    }

    @Override
    public TypeSymbol visit(Variable variable) {
        // If the variable is 'self'
        if (variable.token.getText().equals("self")) {
            return SymbolTable.SELF_TYPE;
        }

        // Look for the symbol in the current scope
        var symbol = (IdSymbol)variable.getScope().lookup(variable.token.getText());

        // Error handling
        // Variable is undefined
        if (symbol == null) {
            SymbolTable.error(variable.ctx, variable.token, "Undefined identifier " + variable.token.getText());
            return null;
        }

        variable.setSymbol(symbol);

        return symbol.getType();
    }
}
