// Generated from C:/Users/mihnea.tudor/OneDrive - Universitatea Politehnica Bucuresti/ACS Cursuri/Anul 4/Semestrul 1/CPL Compilatoare/Homework/Tema 2/Schelet + checker - IntelliJ/Tema2/src/cool/parser/CoolParser.g4 by ANTLR 4.13.1

    package cool.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CoolParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(CoolParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(CoolParser.FeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(CoolParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(CoolParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(CoolParser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(CoolParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinus(CoolParser.PlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invert}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvert(CoolParser.InvertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(CoolParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(CoolParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objVal}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjVal(CoolParser.ObjValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(CoolParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implicitDispatch}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitDispatch(CoolParser.ImplicitDispatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(CoolParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(CoolParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(CoolParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isVoid}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsVoid(CoolParser.IsVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(CoolParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code explicitDispatch}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitDispatch(CoolParser.ExplicitDispatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanOp}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOp(CoolParser.BooleanOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CoolParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(CoolParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(CoolParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code case}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(CoolParser.CaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(CoolParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#localVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDef(CoolParser.LocalVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#caseBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBranch(CoolParser.CaseBranchContext ctx);
}