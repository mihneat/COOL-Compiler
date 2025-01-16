package cool.structures;

import java.io.File;

import org.antlr.v4.runtime.*;

import cool.compiler.Compiler;
import cool.parser.CoolParser;

public class SymbolTable {
    public static Scope globals;
    
    private static boolean semanticErrors;

    public static final String OBJECT_STR = "Object";
    public static final String IO_STR = "IO";
    public static final String INT_STR = "Int";
    public static final String STRING_STR = "String";
    public static final String BOOL_STR = "Bool";
    public static final String SELF_TYPE_STR = "SELF_TYPE";

    public static final TypeSymbol OBJECT = new TypeSymbol(OBJECT_STR);
    public static final TypeSymbol IO = new TypeSymbol(IO_STR, OBJECT);
    public static final TypeSymbol INT = new TypeSymbol(INT_STR, OBJECT);
    public static final TypeSymbol STRING = new TypeSymbol(STRING_STR, OBJECT);
    public static final TypeSymbol BOOL = new TypeSymbol(BOOL_STR, OBJECT);
    public static final TypeSymbol SELF_TYPE = new TypeSymbol(SELF_TYPE_STR, OBJECT);

    public static void defineBasicClasses() {
        globals = new DefaultScope(null);
        semanticErrors = false;
        
        // Populate global scope.
        // Create the classes' methods
        // Object
        OBJECT.setTag(0);
        OBJECT.setMaxTag(4);

        FunctionSymbol abortFn = new FunctionSymbol("abort", OBJECT);
        abortFn.setType(OBJECT);
        abortFn.setTypeStr(OBJECT_STR);
        OBJECT.add(abortFn);

        FunctionSymbol typeNameFn = new FunctionSymbol("type_name", OBJECT);
        typeNameFn.setType(STRING);
        typeNameFn.setTypeStr(STRING_STR);
        OBJECT.add(typeNameFn);

        FunctionSymbol copyFn = new FunctionSymbol("copy", OBJECT);
        copyFn.setType(SELF_TYPE);
        copyFn.setTypeStr(SELF_TYPE_STR);
        OBJECT.add(copyFn);

        // IO
        IO.setTag(1);
        IO.setMaxTag(1);

        FunctionSymbol outStringFn = new FunctionSymbol("out_string", IO);
        outStringFn.setType(SELF_TYPE);
        outStringFn.setTypeStr(SELF_TYPE_STR);
        IdSymbol outString_formalX = new IdSymbol("x");
        outString_formalX.setType(STRING);
        outString_formalX.setTypeStr(STRING_STR);
        outStringFn.add(outString_formalX);
        IO.add(outStringFn);

        FunctionSymbol outIntFn = new FunctionSymbol("out_int", IO);
        outIntFn.setType(SELF_TYPE);
        outIntFn.setTypeStr(SELF_TYPE_STR);
        IdSymbol outIntFn_formalX = new IdSymbol("x");
        outIntFn_formalX.setType(INT);
        outIntFn_formalX.setTypeStr(INT_STR);
        outIntFn.add(outIntFn_formalX);
        IO.add(outIntFn);

        FunctionSymbol inStringFn = new FunctionSymbol("in_string", IO);
        inStringFn.setType(STRING);
        inStringFn.setTypeStr(STRING_STR);
        IO.add(inStringFn);

        FunctionSymbol inIntFn = new FunctionSymbol("in_int", IO);
        inIntFn.setType(INT);
        inIntFn.setTypeStr(INT_STR);
        IO.add(inIntFn);

        // Int
        INT.setTag(2);
        INT.setMaxTag(2);

        // String
        STRING.setTag(3);
        STRING.setMaxTag(3);

        FunctionSymbol lengthFn = new FunctionSymbol("length", STRING);
        lengthFn.setType(INT);
        lengthFn.setTypeStr(INT_STR);
        STRING.add(lengthFn);

        FunctionSymbol concatFn = new FunctionSymbol("concat", STRING);
        concatFn.setType(STRING);
        concatFn.setTypeStr(STRING_STR);
        IdSymbol concatFn_formalS = new IdSymbol("s");
        concatFn_formalS.setType(STRING);
        concatFn_formalS.setTypeStr(STRING_STR);
        concatFn.add(concatFn_formalS);
        STRING.add(concatFn);

        FunctionSymbol substrFn = new FunctionSymbol("substr", STRING);
        substrFn.setType(STRING);
        substrFn.setTypeStr(STRING_STR);
        IdSymbol substrFn_formalI = new IdSymbol("i");
        substrFn_formalI.setType(INT);
        substrFn_formalI.setTypeStr(INT_STR);
        substrFn.add(substrFn_formalI);
        IdSymbol substrFn_formalL = new IdSymbol("l");
        substrFn_formalL.setType(INT);
        substrFn_formalL.setTypeStr(INT_STR);
        substrFn.add(substrFn_formalL);
        STRING.add(substrFn);

        // Bool
        BOOL.setTag(4);
        BOOL.setMaxTag(4);

        // Add the classes to the global scope
        globals.add(OBJECT);
        globals.add(IO);
        globals.add(INT);
        globals.add(STRING);
        globals.add(BOOL);
        globals.add(SELF_TYPE);
    }

    public static void resetMaxTags() {
        OBJECT.setMaxTagForce(4);
        IO.setMaxTagForce(1);
        INT.setMaxTagForce(2);
        STRING.setMaxTagForce(3);
        BOOL.setMaxTagForce(4);
    }
    
    /**
     * Displays a semantic error message.
     * 
     * @param ctx Used to determine the enclosing class context of this error,
     *            which knows the file name in which the class was defined.
     * @param info Used for line and column information.
     * @param str The error message.
     */
    public static void error(ParserRuleContext ctx, Token info, String str) {
        while (! (ctx.getParent() instanceof CoolParser.ProgramContext))
            ctx = ctx.getParent();
        
        String message = "\"" + new File(Compiler.fileNames.get(ctx)).getName()
                + "\", line " + info.getLine()
                + ":" + (info.getCharPositionInLine() + 1)
                + ", Semantic error: " + str;
        
        System.err.println(message);
        
        semanticErrors = true;
    }
    
    public static void error(String str) {
        String message = "Semantic error: " + str;
        
        System.err.println(message);
        
        semanticErrors = true;
    }
    
    public static boolean hasSemanticErrors() {
        return semanticErrors;
    }
}
