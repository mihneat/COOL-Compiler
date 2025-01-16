package cool.compiler;

import cool.structures.IdSymbol;
import cool.structures.Scope;
import cool.structures.TypeSymbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public abstract class ASTNode {

    ParserRuleContext ctx;
    Token token;

    ASTNode(ParserRuleContext ctx, Token token) {
        this.ctx = ctx;
        this.token = token;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }
}

class Program extends ASTNode {

    ArrayList<Class> classes;

    Program(ParserRuleContext ctx, Token token, ArrayList<Class> classes) {
        super(ctx, token);
        this.classes = classes;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Class extends ASTNode {

    Type name;
    Type parent;
    ArrayList<Definition> definitions;

    Class(ParserRuleContext ctx, Token token, Type name, Type parent, ArrayList<Definition> definitions) {
        super(ctx, token);
        this.name = name;
        this.parent = parent;
        this.definitions = definitions;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class Definition extends ASTNode {

    Definition(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }
}

class Attribute extends Definition {

    Variable name;
    Type type;
    Expression init;

    Attribute(ParserRuleContext ctx, Token token, Variable name, Type type, Expression init) {
        super(ctx, token);
        this.name = name;
        this.type = type;
        this.init = init;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Method extends Definition {

    Variable name;
    ArrayList<Formal> params;
    Type type;
    Expression body;

    Method(ParserRuleContext ctx, Token token, Variable name, ArrayList<Formal> params, Type type, Expression body) {
        super(ctx, token);
        this.name = name;
        this.params = params;
        this.type = type;
        this.body = body;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Formal extends Definition {

    Variable name;
    Type type;

    Formal(ParserRuleContext ctx, Token token, Variable name, Type type) {
        super(ctx, token);
        this.name = name;
        this.type = type;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class LocalAttribute extends Definition {

    Variable name;
    Type type;
    Expression init;

    LocalAttribute(ParserRuleContext ctx, Token token, Variable name, Type type, Expression init) {
        super(ctx, token);
        this.name = name;
        this.type = type;
        this.init = init;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class Expression extends ASTNode {

    TypeSymbol type;

    Expression(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }

    public TypeSymbol getType() {
        return type;
    }

    public void setType(TypeSymbol type) {
        this.type = type;
    }
}

class BinaryOperation extends Expression {

    Expression left, right;

    BinaryOperation(ParserRuleContext ctx, Token token, Expression left, Expression right) {
        super(ctx, token);
        this.left = left;
        this.right = right;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class UnaryOperation extends Expression {

    Expression operand;

    UnaryOperation(ParserRuleContext ctx, Token token, Expression operand) {
        super(ctx, token);
        this.operand = operand;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Assignment extends Expression {

    Variable name;
    Expression value;

    Assignment(ParserRuleContext ctx, Token token, Variable name, Expression value) {
        super(ctx, token);
        this.name = name;
        this.value = value;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class New extends Expression {

    Type type;

    New(ParserRuleContext ctx, Token token, Type type) {
        super(ctx, token);
        this.type = type;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class Dispatch extends Expression {

    Variable method;
    ArrayList<Expression> params;

    Dispatch(ParserRuleContext ctx, Token token, Variable method, ArrayList<Expression> params) {
        super(ctx, token);
        this.method = method;
        this.params = params;
    }
}

class ExplicitDispatch extends Dispatch {

    Expression obj;
    Type staticType;

    ExplicitDispatch(ParserRuleContext ctx, Token token, Expression obj, Type staticType, Variable method, ArrayList<Expression> params) {
        super(ctx, token, method, params);
        this.obj = obj;
        this.staticType = staticType;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class ImplicitDispatch extends Dispatch {

    ImplicitDispatch(ParserRuleContext ctx, Token token, Variable method, ArrayList<Expression> params) {
        super(ctx, token, method, params);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class If extends Expression {

    Expression cond, then, else_;

    If(ParserRuleContext ctx, Token token, Expression cond, Expression then, Expression else_) {
        super(ctx, token);
        this.cond = cond;
        this.then = then;
        this.else_ = else_;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class While extends Expression {

    Expression cond, body;

    While(ParserRuleContext ctx, Token token, Expression cond, Expression body) {
        super(ctx, token);
        this.cond = cond;
        this.body = body;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Let extends Expression {

    ArrayList<LocalAttribute> defs;
    Expression body;

    Let(ParserRuleContext ctx, Token token, ArrayList<LocalAttribute> defs, Expression body) {
        super(ctx, token);
        this.defs = defs;
        this.body = body;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Case extends Expression {

    Expression expr;
    ArrayList<CaseBranch> branches;

    Case(ParserRuleContext ctx, Token token, Expression expr, ArrayList<CaseBranch> branches) {
        super(ctx, token);
        this.expr = expr;
        this.branches = branches;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class CaseBranch extends ASTNode {

    Variable name;
    Type type;
    Expression body;

    CaseBranch(ParserRuleContext ctx, Token token, Variable name, Type type, Expression body) {
        super(ctx, token);
        this.name = name;
        this.type = type;
        this.body = body;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Block extends Expression {

    ArrayList<Expression> expressions;

    Block(ParserRuleContext ctx, Token token, ArrayList<Expression> expressions) {
        super(ctx, token);
        this.expressions = expressions;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Variable extends Expression {

    private IdSymbol symbol;
    private Scope scope;

    Variable(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    IdSymbol getSymbol() {
        return symbol;
    }

    void setSymbol(IdSymbol symbol) {
        this.symbol = symbol;
    }

    Scope getScope() {
        return scope;
    }

    void setScope(Scope scope) {
        this.scope = scope;
    }
}

class Int extends Expression {

    Int(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class String_ extends Expression {

    String_(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Bool extends Expression {

    Bool(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Type extends ASTNode {

    private TypeSymbol typeSymbol;

    Type(ParserRuleContext ctx, Token token) {
        super(ctx, token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeSymbol getTypeSymbol() {
        return typeSymbol;
    }

    public void setTypeSymbol(TypeSymbol typeSymbol) {
        this.typeSymbol = typeSymbol;
    }
}
