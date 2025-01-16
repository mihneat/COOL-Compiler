package cool.compiler;

import cool.parser.CoolParser;
import cool.parser.CoolParserBaseVisitor;

import java.util.ArrayList;

/**
 * Visitor applied on the *parse tree*, which creates the associated Abstract Syntax Tree.
 */
public class ASTConstructionVisitor extends CoolParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(CoolParser.ProgramContext ctx) {
        // Form a list of all the classes
        ArrayList<Class> classes = new ArrayList<>();
        for (var cls : ctx.class_()) {
            classes.add((Class)visit(cls));
        }

        return new Program(ctx, ctx.start, classes);
    }

    @Override
    public ASTNode visitClass(CoolParser.ClassContext ctx) {
        ArrayList<Definition> definitions = null;
        if (ctx.feature() != null) {
            definitions = new ArrayList<>();
            for (var def : ctx.feature()) {
                definitions.add((Definition)visit(def));
            }
        }

        return new Class(
                ctx,
                ctx.start,
                new Type(ctx, ctx.this_),
                ctx.parent != null ? new Type(ctx, ctx.parent) : null,
                definitions
        );
    }

    @Override
    public ASTNode visitAttribute(CoolParser.AttributeContext ctx) {
        return new Attribute(
                ctx,
                ctx.start,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                new Type(ctx, ctx.TYPE_ID().getSymbol()),
                ctx.expr() != null ? (Expression)visit(ctx.expr()) : null
        );
    }

    @Override
    public ASTNode visitMethod(CoolParser.MethodContext ctx) {
        ArrayList<Formal> formals = new ArrayList<>();
        if (ctx.formal() != null) {
            for (var formal : ctx.formal()) {
                formals.add((Formal)visit(formal));
            }
        }

        return new Method(
                ctx,
                ctx.start,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                formals,
                new Type(ctx, ctx.TYPE_ID().getSymbol()),
                (Expression)visit(ctx.expr())
        );
    }

    @Override
    public ASTNode visitFormal(CoolParser.FormalContext ctx) {
        return new Formal(
                ctx,
                ctx.start,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                new Type(ctx, ctx.TYPE_ID().getSymbol())
        );
    }

    @Override
    public ASTNode visitLocalVarDef(CoolParser.LocalVarDefContext ctx) {
        return new LocalAttribute(
                ctx,
                ctx.start,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                new Type(ctx, ctx.TYPE_ID().getSymbol()),
                ctx.expr() != null ? (Expression)visit(ctx.expr()) : null
        );
    }

    @Override
    public ASTNode visitPlusMinus(CoolParser.PlusMinusContext ctx) {
        return new BinaryOperation(
                ctx,
                ctx.PLUS() != null ? ctx.PLUS().getSymbol() : ctx.MINUS().getSymbol(),
                (Expression)visit(ctx.left),
                (Expression)visit(ctx.right)
        );
    }

    @Override
    public ASTNode visitMulDiv(CoolParser.MulDivContext ctx) {
        return new BinaryOperation(
                ctx,
                ctx.STAR() != null ? ctx.STAR().getSymbol() : ctx.SLASH().getSymbol(),
                (Expression)visit(ctx.left),
                (Expression)visit(ctx.right)
        );
    }

    @Override
    public ASTNode visitInvert(CoolParser.InvertContext ctx) {
        return new UnaryOperation(
                ctx,
                ctx.INVERSE().getSymbol(),
                (Expression)visit(ctx.expr())
        );
    }

    @Override
    public ASTNode visitBooleanOp(CoolParser.BooleanOpContext ctx) {
        return new BinaryOperation(
                ctx,
                ctx.LE() != null ? ctx.LE().getSymbol() : (ctx.LT() != null ? ctx.LT().getSymbol() : ctx.EQ().getSymbol()),
                (Expression)visit(ctx.left),
                (Expression)visit(ctx.right)
        );
    }

    @Override
    public ASTNode visitNegate(CoolParser.NegateContext ctx) {
        return new UnaryOperation(
                ctx,
                ctx.NOT().getSymbol(),
                (Expression)visit(ctx.expr())
        );
    }

    @Override
    public ASTNode visitAssign(CoolParser.AssignContext ctx) {
        return new Assignment(
                ctx,
                ctx.ASSIGN().getSymbol(),
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                (Expression)visit(ctx.expr())
        );
    }

    @Override
    public ASTNode visitIsVoid(CoolParser.IsVoidContext ctx) {
        return new UnaryOperation(
                ctx,
                ctx.ISVOID().getSymbol(),
                (Expression)visit(ctx.expr())
        );
    }

    @Override
    public ASTNode visitNew(CoolParser.NewContext ctx) {
        return new New(
                ctx,
                ctx.NEW().getSymbol(),
                new Type(ctx, ctx.TYPE_ID().getSymbol())
        );
    }

    @Override
    public ASTNode visitExplicitDispatch(CoolParser.ExplicitDispatchContext ctx) {
        ArrayList<Expression> params = new ArrayList<>();
        if (ctx.params != null) {
            for (var param : ctx.params) {
                params.add((Expression)visit(param));
            }
        }

        return new ExplicitDispatch(
                ctx,
                ctx.start,
                (Expression)visit(ctx.obj),
                ctx.TYPE_ID() != null ? new Type(ctx, ctx.TYPE_ID().getSymbol()) : null,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                params
        );
    }

    @Override
    public ASTNode visitImplicitDispatch(CoolParser.ImplicitDispatchContext ctx) {
        ArrayList<Expression> params = new ArrayList<>();
        if (ctx.params != null) {
            for (var param : ctx.params) {
                params.add((Expression)visit(param));
            }
        }

        return new ImplicitDispatch(
                ctx,
                ctx.start,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                params
        );
    }

    @Override
    public ASTNode visitIf(CoolParser.IfContext ctx) {
        return new If(
                ctx,
                ctx.start,
                (Expression)visit(ctx.cond),
                (Expression)visit(ctx.then),
                (Expression)visit(ctx.else_)
        );
    }

    @Override
    public ASTNode visitWhile(CoolParser.WhileContext ctx) {
        return new While(
                ctx,
                ctx.start,
                (Expression)visit(ctx.cond),
                (Expression)visit(ctx.body)
        );
    }

    @Override
    public ASTNode visitLet(CoolParser.LetContext ctx) {
        ArrayList<LocalAttribute> defs = new ArrayList<>();

        for (var def : ctx.defs) {
            defs.add((LocalAttribute)visit(def));
        }

        return new Let(
                ctx,
                ctx.start,
                defs,
                (Expression)visit(ctx.body)
        );
    }

    @Override
    public ASTNode visitCase(CoolParser.CaseContext ctx) {
        ArrayList<CaseBranch> branches = new ArrayList<>();

        for (var branch : ctx.caseBranch()) {
            branches.add((CaseBranch)visit(branch));
        }

        return new Case(
                ctx,
                ctx.start,
                (Expression)visit(ctx.expr()),
                branches
        );
    }

    @Override
    public ASTNode visitCaseBranch(CoolParser.CaseBranchContext ctx) {
        return new CaseBranch(
                ctx,
                ctx.start,
                new Variable(ctx, ctx.OBJECT_ID().getSymbol()),
                new Type(ctx, ctx.TYPE_ID().getSymbol()),
                (Expression)visit(ctx.expr())
        );
    }

    @Override
    public ASTNode visitBlock(CoolParser.BlockContext ctx) {
        ArrayList<Expression> expressions = new ArrayList<>();

        for (var expr : ctx.expr()) {
            expressions.add((Expression)visit(expr));
        }

        return new Block(
                ctx,
                ctx.start,
                expressions
        );
    }

    @Override
    public ASTNode visitParen(CoolParser.ParenContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitObjVal(CoolParser.ObjValContext ctx) {
        return new Variable(ctx, ctx.OBJECT_ID().getSymbol());
    }

    @Override
    public ASTNode visitInt(CoolParser.IntContext ctx) {
        return new Int(ctx, ctx.INT().getSymbol());
    }

    @Override
    public ASTNode visitString(CoolParser.StringContext ctx) {
        return new String_(ctx, ctx.STRING().getSymbol());
    }

    @Override
    public ASTNode visitBool(CoolParser.BoolContext ctx) {
        return new Bool(ctx, ctx.TRUE() != null ? ctx.TRUE().getSymbol() : ctx.FALSE().getSymbol());
    }
}
