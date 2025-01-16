package cool.compiler;

import cool.structures.FunctionSymbol;
import cool.structures.SymbolTable;
import cool.structures.TypeSymbol;
import org.antlr.v4.runtime.misc.Pair;
import org.stringtemplate.v4.ST;

import java.util.LinkedHashMap;
import java.util.List;

public class OffsetCalculatorVisitor implements ASTVisitor<Void> {
    int currClassTag = 4;
    int currLocalsCnt = 0;

    public int generateClassTag() {
        return ++currClassTag;
    }

    private void calculateOffsetsForClass(TypeSymbol class_) {
        // Get the inheritance chain
        List<TypeSymbol> inheritanceChain = Utils.getInheritanceChainForType(class_);
        
        // Iterate through the chain and set the class tags
        int maxTag = 0;
        for (TypeSymbol cls : inheritanceChain) {
            if (cls.getTag() == 0 && cls != SymbolTable.OBJECT) {
                cls.setTag(generateClassTag());
            }

            maxTag = cls.getTag();
        }

        for (TypeSymbol cls : inheritanceChain) {
            cls.setMaxTag(maxTag);

            // System.out.println("# " + cls.getName() + " - " + cls.getTag() + " - " + cls.getMaxTag());
        }

        // Iterate through the chain and extract the methods
        int currOffset = 0;
        LinkedHashMap<String, Pair<String, Integer>> methods = new LinkedHashMap<>();
        for (TypeSymbol cls : inheritanceChain) {
            for (var method : cls.getMethods().entrySet()) {
                // Extract the fields
                String methodName = method.getKey();
                FunctionSymbol methodSymbol = method.getValue();

                if (!methods.containsKey(methodName)) {
                    // Add the method offset
                    methodSymbol.setOffset(currOffset);

                    // Store the method in the map
                    methods.put(methodName, new Pair<>(cls.getName(), currOffset));

                    // Increase the offset
                    currOffset += 4;

                    continue;
                }

                var pair = methods.get(methodName);

                methodSymbol.setOffset(pair.b);

                methods.put(methodName, new Pair<>(cls.getName(), pair.b));
            }
        }
    }

    @Override
    public Void visit(Program program) {
        // Calculate offsets for predefined classes
        calculateOffsetsForClass(SymbolTable.OBJECT);
        calculateOffsetsForClass(SymbolTable.IO);
        calculateOffsetsForClass(SymbolTable.INT);
        calculateOffsetsForClass(SymbolTable.STRING);
        calculateOffsetsForClass(SymbolTable.BOOL);

        for (ASTNode cls : program.classes)
            cls.accept(this);

        return null;
    }

    @Override
    public Void visit(Class class_) {
        // Init
        TypeSymbol symbol = class_.name.getTypeSymbol();

        // Calculate offsets for the current class
        calculateOffsetsForClass(symbol);

        // Get the inheritance chain
        List<TypeSymbol> inheritanceChain = Utils.getInheritanceChainForType(symbol);

        // Find the attributes
        int attributeCnt = 0;
        for (TypeSymbol cls : inheritanceChain) {
            for (var attribute : cls.getAttributes().values()) {
                attribute.setOffset(12 + attributeCnt * 4);
                ++attributeCnt;
            }
        }

        for (var def : class_.definitions) {
            currLocalsCnt = 0;
            def.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Attribute attribute) {
        if (attribute.init != null) {
            attribute.init.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Method method) {
        if (method.params != null) {
            int offset = 3;
            for (var formal : method.params) {
                formal.name.getSymbol().setOffset(offset * 4);
                offset += 1;
            }
        }

        method.body.accept(this);

        ((FunctionSymbol) method.name.getSymbol()).setLocalsCnt(currLocalsCnt);

        return null;
    }

    @Override
    public Void visit(Formal formal) {
        return null;
    }

    @Override
    public Void visit(LocalAttribute localAttribute) {
        ++currLocalsCnt;
        localAttribute.name.getSymbol().setOffset(-4 * currLocalsCnt);

        if (localAttribute.init != null) {
            localAttribute.init.accept(this);
        }

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
        assignment.value.accept(this);

        return null;
    }

    @Override
    public Void visit(New new_) {
        return null;
    }

    @Override
    public Void visit(ExplicitDispatch explicitDispatch) {
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

        return null;
    }

    @Override
    public Void visit(Case case_) {
        case_.expr.accept(this);

        // Consider all branch variables as one
        ++currLocalsCnt;

        // Offset pass
        for (var branch : case_.branches) {
            branch.accept(this);
        }

        // Expression evaluation pass
        for (var branch : case_.branches) {
            branch.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(CaseBranch caseBranch) {
        // If offset is unset
        if (caseBranch.name.getSymbol().getOffset() == 0) {
            caseBranch.name.getSymbol().setOffset(-4 * currLocalsCnt);
            return null;
        }

        caseBranch.body.accept(this);

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
        return null;
    }
}
