package cool.compiler;

public interface ASTVisitor<T> {

    T visit(Program program);
    T visit(Class class_);
    T visit(Attribute attribute);
    T visit(Method method);
    T visit(Formal formal);
    T visit(LocalAttribute localAttribute);
    T visit(BinaryOperation binaryOperation);
    T visit(UnaryOperation unaryOperation);
    T visit(Assignment assignment);
    T visit(New new_);
    T visit(ExplicitDispatch explicitDispatch);
    T visit(ImplicitDispatch implicitDispatch);
    T visit(If if_);
    T visit(While while_);
    T visit(Let let);
    T visit(Case case_);
    T visit(CaseBranch caseBranch);
    T visit(Block block);
    T visit(Int int_);
    T visit(String_ string);
    T visit(Bool bool);
    T visit(Type type);
    T visit(Variable variable);

}
