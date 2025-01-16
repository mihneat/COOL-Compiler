package cool.compiler;

/**
 * Visitor applied on the *abstract syntax tree*, used to print its structure.
 */
public class ASTPrintVisitor implements ASTVisitor<Void> {
    int indent = 0;

    void printIndent(String str) {
        for (int i = 0; i < indent; i++)
            System.out.print("  ");

        System.out.println(str);
    }

    @Override
    public Void visit(Program program) {
        printIndent("program");

        indent++;
        for (var cls : program.classes) {
            cls.accept(this);
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(Class class_) {
        printIndent("class");

        indent++;
        class_.name.accept(this);
        if (class_.parent != null) {
            class_.parent.accept(this);
        }

        if (class_.definitions != null) {
            for (var def : class_.definitions) {
                def.accept(this);
            }
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(Attribute attribute) {
        printIndent("attribute");

        indent++;
        attribute.name.accept(this);
        attribute.type.accept(this);
        if (attribute.init != null) {
            attribute.init.accept(this);
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(Method method) {
        printIndent("method");

        indent++;
        method.name.accept(this);
        if (method.params != null) {
            for (var param : method.params) {
                param.accept(this);
            }
        }
        method.type.accept(this);

        method.body.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(Formal formal) {
        printIndent("formal");

        indent++;
        formal.name.accept(this);
        formal.type.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(LocalAttribute localAttribute) {
        printIndent("local");

        indent++;
        localAttribute.name.accept(this);
        localAttribute.type.accept(this);
        if (localAttribute.init != null) {
            localAttribute.init.accept(this);
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(BinaryOperation binaryOperation) {
        printIndent(binaryOperation.token.getText());

        indent++;
        binaryOperation.left.accept(this);
        binaryOperation.right.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(UnaryOperation unaryOperation) {
        printIndent(unaryOperation.token.getText());

        indent++;
        unaryOperation.operand.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(Assignment assignment) {
        printIndent(assignment.token.getText());

        indent++;
        assignment.name.accept(this);
        assignment.value.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(New new_) {
        printIndent(new_.token.getText());

        indent++;
        new_.type.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(ExplicitDispatch explicitDispatch) {
        printIndent(".");

        indent++;
        explicitDispatch.obj.accept(this);
        if (explicitDispatch.staticType != null) {
            explicitDispatch.staticType.accept(this);
        }
        explicitDispatch.method.accept(this);
        if (explicitDispatch.params != null) {
            for (var param : explicitDispatch.params) {
                param.accept(this);
            }
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(ImplicitDispatch implicitDispatch) {
        printIndent("implicit dispatch");

        indent++;
        implicitDispatch.method.accept(this);
        if (implicitDispatch.params != null) {
            for (var param : implicitDispatch.params) {
                param.accept(this);
            }
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(If if_) {
        printIndent("if");

        indent++;
        if_.cond.accept(this);
        if_.then.accept(this);
        if_.else_.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(While while_) {
        printIndent("while");

        indent++;
        while_.cond.accept(this);
        while_.body.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(Let let) {
        printIndent("let");

        indent++;
        for (var def : let.defs) {
            def.accept(this);
        }
        let.body.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(Case case_) {
        printIndent("case");

        indent++;
        case_.expr.accept(this);
        for (var branch : case_.branches) {
            branch.accept(this);
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(CaseBranch caseBranch) {
        printIndent("case branch");

        indent++;
        caseBranch.name.accept(this);
        caseBranch.type.accept(this);
        caseBranch.body.accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(Block block) {
        printIndent("block");

        indent++;
        for (var expr : block.expressions) {
            expr.accept(this);
        }
        indent--;

        return null;
    }

    @Override
    public Void visit(Int int_) {
        printIndent(int_.token.getText());

        return null;
    }

    @Override
    public Void visit(String_ string) {
        printIndent(string.token.getText());

        return null;
    }

    @Override
    public Void visit(Bool bool) {
        printIndent(bool.token.getText());

        return null;
    }

    @Override
    public Void visit(Type type) {
        printIndent(type.token.getText());

        return null;
    }

    @Override
    public Void visit(Variable variable) {
        printIndent(variable.token.getText());

        return null;
    }
}
