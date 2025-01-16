package cool.compiler;

import cool.parser.CoolParser;
import cool.structures.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.util.*;

public class CodeGenVisitor implements ASTVisitor<ST> {
    static STGroupFile templates = new STGroupFile("cool/compiler/cgen.stg");

    ST strConstsSection;
    ST intConstsSection;
    ST classNameTabSection;
    ST classObjTabSection;
    ST classProtObjSection;
    ST classDispTabSection;
    ST classInitSection;
    ST textMainSection;

    ST attrInitSeq;

    Map<String, Integer> apparitionCnt = new HashMap<>();
    int currStrConstIdx = -1;

    HashSet<Integer> ints = new HashSet<>();
    HashMap<String, Integer> strs = new HashMap<>();

    HashSet<TypeSymbol> nameTabEntries = new HashSet<>();

    String currEndCaseLabel;

    public String genLabel(String label) {
        int cnt = apparitionCnt.getOrDefault(label, 0);
        apparitionCnt.put(label, cnt + 1);

        return label + "_" + cnt;
    }

    public void addIfMissingInt(int n) {
        if (ints.contains(n)) {
            return;
        }

        ints.add(n);
        intConstsSection.add("e", templates.getInstanceOf("intConst").add("n", n));
    }

    public int addIfMissingStr(String str) {
        if (strs.containsKey(str)) {
            return strs.get(str);
        }

        // Increment the string idx
        ++currStrConstIdx;

        // Get the string length
        int len = str.length();

        // Size = 4 <3 header + 1 int> + (len + 1) / 4 <string len + terminator, divided by a word length of 4>
        // Optimization: len + 1 + 3, a hack for getting the ceil() of the division above
        int size = 4 + (len + 4) / 4;

        // Add the len as a constant integer
        addIfMissingInt(len);

        strs.put(str, currStrConstIdx);

        var strConstST = templates.getInstanceOf("strConst")
                .add("idx", currStrConstIdx)
                .add("size", size)
                .add("intIdx", len)
                .add("str", str);
        strConstsSection.add("e", strConstST);

        return currStrConstIdx;
    }

    @Override
    public ST visit(Program program) {
        strConstsSection = templates.getInstanceOf("sequence");
        intConstsSection = templates.getInstanceOf("sequence");
        classNameTabSection = templates.getInstanceOf("sequence");
        classObjTabSection = templates.getInstanceOf("sequence");
        classProtObjSection = templates.getInstanceOf("sequence");
        classDispTabSection = templates.getInstanceOf("sequence");
        classInitSection = templates.getInstanceOf("sequence");
        textMainSection = templates.getInstanceOf("sequence");

        // Add integers 0-6
        for (int i = 0; i <= 6; ++i) {
            addIfMissingInt(i);
        }

        // Add the predefined class strings
        addIfMissingStr("");
        addIfMissingStr("Object");
        addIfMissingStr("IO");
        addIfMissingStr("Int");
        addIfMissingStr("String");
        addIfMissingStr("Bool");

        // Add them to the name table
        classNameTabSection.add("e", templates.getInstanceOf("nameTab").add("strIdx", 1));
        classNameTabSection.add("e", templates.getInstanceOf("nameTab").add("strIdx", 2));
        classNameTabSection.add("e", templates.getInstanceOf("nameTab").add("strIdx", 3));
        classNameTabSection.add("e", templates.getInstanceOf("nameTab").add("strIdx", 4));
        classNameTabSection.add("e", templates.getInstanceOf("nameTab").add("strIdx", 5));
        nameTabEntries.add(SymbolTable.OBJECT);
        nameTabEntries.add(SymbolTable.IO);
        nameTabEntries.add(SymbolTable.INT);
        nameTabEntries.add(SymbolTable.STRING);
        nameTabEntries.add(SymbolTable.BOOL);

        for (ASTNode cls : program.classes)
            textMainSection.add("e", cls.accept(this));

        // Reset max tags
        SymbolTable.resetMaxTags();

        var programST = templates.getInstanceOf("program");
        programST.add("strConsts", strConstsSection);
        programST.add("intConsts", intConstsSection);
        programST.add("classNameTab", classNameTabSection);
        programST.add("classObjTab", classObjTabSection);
        programST.add("classProtObj", classProtObjSection);
        programST.add("classDispTab", classDispTabSection);
        programST.add("classInit", classInitSection);
        programST.add("textMain", textMainSection);

        return programST;
    }

    @Override
    public ST visit(Class class_) {
        // Init
        TypeSymbol symbol = class_.name.getTypeSymbol();

        //// Chapter 1: Create the prototype
        // Find the inheritance chain
        List<TypeSymbol> inheritanceChain = Utils.getInheritanceChainForType(symbol);

        // Find the attributes
        int attributeCnt = 0;
        var attributesST = templates.getInstanceOf("sequence");
        for (TypeSymbol cls : inheritanceChain) {
            for (var attribute : cls.getAttributes().values()) {
                ++attributeCnt;

                // Create attribute data
                ST protoAttributeST;
                TypeSymbol type = attribute.getType();
                if (type == SymbolTable.STRING) {
                    protoAttributeST = templates.getInstanceOf("protoAttribute")
                            .add("label", "str_const0");
                } else if (type == SymbolTable.INT) {
                    protoAttributeST = templates.getInstanceOf("protoAttribute")
                            .add("label", "int_const0");
                } else if (type == SymbolTable.BOOL) {
                    protoAttributeST = templates.getInstanceOf("protoAttribute")
                            .add("label", "bool_const0");
                } else {
                    protoAttributeST = templates.getInstanceOf("protoAttribute")
                            .add("label", 0);
                }

                attributesST.add("e", protoAttributeST);
            }
        }

        // Form the string template
        var protObjST = templates.getInstanceOf("protObj")
                .add("className", symbol.getName())
                .add("tag", symbol.getTag())
                .add("size", 3 + attributeCnt)
                .add("attributes", attributesST);

        classProtObjSection.add("e", protObjST);

        //// Chapter 2: Create the disp tab
        // Iterate through the chain and extract the methods
        LinkedHashMap<String, String> methods = new LinkedHashMap<>();
        for (TypeSymbol cls : inheritanceChain) {
            for (var method : cls.getMethods().entrySet()) {
                // Extract the fields
                String methodName = method.getKey();

                methods.put(methodName, cls.getName());
            }
        }

        var dispEntriesST = templates.getInstanceOf("sequence");
        for (var method : methods.entrySet()) {
            // Extract the fields
            String methodName = method.getKey();
            String className = method.getValue();

            // Add the entry
            var dispTabEntryST = templates.getInstanceOf("dispTabEntry")
                    .add("className", className)
                    .add("methodName", methodName);
            dispEntriesST.add("e", dispTabEntryST);
        }

        // Form the string template
        var dispTabST = templates.getInstanceOf("dispTab")
                        .add("className", symbol.getName())
                        .add("methods", dispEntriesST);

        classDispTabSection.add("e", dispTabST);

        //// Chapter 3: Add the object and name to the tables
        for (TypeSymbol cls : inheritanceChain) {
            if (nameTabEntries.contains(cls)) {
                continue;
            }

            nameTabEntries.add(cls);

            var nameTabST = templates.getInstanceOf("nameTab")
                    .add("strIdx", addIfMissingStr(symbol.getName()));

            classNameTabSection.add("e", nameTabST);
        }

        var objTabST = templates.getInstanceOf("objTab")
                .add("className", symbol.getName());

        classObjTabSection.add("e", objTabST);

        //// Chapter 4: Visit the definitions and form the main text
        attrInitSeq = templates.getInstanceOf("sequence");
        var definitionsST = templates.getInstanceOf("sequence");
        for (var def : class_.definitions) {
            definitionsST.add("e", def.accept(this));
        }

        //// Chapter 5: Create the init sequence
        // Form the string template
        var classInitST = templates.getInstanceOf("classInit")
                .add("className", symbol.getName())
                .add("parentName", ((TypeSymbol)symbol.getParent()).getName())
                .add("attributeInits", attrInitSeq);

        classInitSection.add("e", classInitST);

        return definitionsST;
    }

    @Override
    public ST visit(Attribute attribute) {
        if (attribute.init != null) {
            var attributeInitSeq = templates.getInstanceOf("attributeInit")
                    .add("e", attribute.init.accept(this))
                    .add("offset", attribute.name.getSymbol().getOffset());

            attrInitSeq.add("e", attributeInitSeq);
        }

        return null;
    }

    @Override
    public ST visit(Method method) {
        return templates.getInstanceOf("methodDef")
                .add("className", ((TypeSymbol)method.name.getScope().getParent()).getName())
                .add("methodName", method.name.getSymbol().getName())
                .add("e", method.body.accept(this))
                .add("paramSize", method.params == null ? 0 : 4 * method.params.size())
                .add("localsSize", 4 * ((FunctionSymbol) method.name.getSymbol()).getLocalsCnt());
    }

    @Override
    public ST visit(Formal formal) {
        return null;
    }

    @Override
    public ST visit(LocalAttribute localAttribute) {
        var localDefST = templates.getInstanceOf("localDef")
                .add("offset", localAttribute.name.getSymbol().getOffset());
        if (localAttribute.init != null) {
            localDefST.add("e", localAttribute.init.accept(this));
        } else {
            TypeSymbol type = localAttribute.name.getSymbol().getType();
            if (type == SymbolTable.STRING) {
                localDefST.add("e", "    la      $a0 str_const0");
            } else if (type == SymbolTable.INT) {
                localDefST.add("e", "    la      $a0 int_const0");
            } else if (type == SymbolTable.BOOL) {
                localDefST.add("e", "    la      $a0 bool_const0");
            } else {
                localDefST.add("e", "    li      $a0 0");
            }
        }

        return localDefST;
    }

    @Override
    public ST visit(BinaryOperation binaryOperation) {
        // Arithmetic operations
        var binaryOpST = templates.getInstanceOf("arithmetic")
                .add("left", binaryOperation.left.accept(this))
                .add("right", binaryOperation.right.accept(this));
        if (binaryOperation.token.getText().equalsIgnoreCase("+")) {
            return binaryOpST.add("op", "add");
        }

        if (binaryOperation.token.getText().equalsIgnoreCase("-")) {
            return binaryOpST.add("op", "sub");
        }

        if (binaryOperation.token.getText().equalsIgnoreCase("*")) {
            return binaryOpST.add("op", "mul");
        }

        if (binaryOperation.token.getText().equalsIgnoreCase("/")) {
            return binaryOpST.add("op", "div");
        }

        // Boolean operations
        if (binaryOperation.token.getText().equalsIgnoreCase("=")) {
            return templates.getInstanceOf("equal")
                    .add("left", binaryOperation.left.accept(this))
                    .add("right", binaryOperation.right.accept(this))
                    .add("equalLabel", genLabel("equal"));
        }

        if (binaryOperation.token.getText().equalsIgnoreCase("<")) {
            return templates.getInstanceOf("cmp")
                    .add("left", binaryOperation.left.accept(this))
                    .add("right", binaryOperation.right.accept(this))
                    .add("op", "blt")
                    .add("compareLabel", genLabel("compare"));
        }

        if (binaryOperation.token.getText().equalsIgnoreCase("<=")) {
            return templates.getInstanceOf("cmp")
                    .add("left", binaryOperation.left.accept(this))
                    .add("right", binaryOperation.right.accept(this))
                    .add("op", "ble")
                    .add("compareLabel", genLabel("compare"));
        }

        return null;
    }

    @Override
    public ST visit(UnaryOperation unaryOperation) {
        if (unaryOperation.token.getText().equalsIgnoreCase("isvoid")) {
            return templates.getInstanceOf("isvoid")
                    .add("e", unaryOperation.operand.accept(this))
                    .add("isvoidLabel", genLabel("isvoid"))
                    .add("endIsvoidLabel", genLabel("endIsvoid"));
        }

        if (unaryOperation.token.getText().equalsIgnoreCase("not")) {
            return templates.getInstanceOf("not")
                    .add("e", unaryOperation.operand.accept(this))
                    .add("notLabel", genLabel("not"));
        }

        if (unaryOperation.token.getText().equalsIgnoreCase("~")) {
            return templates.getInstanceOf("neg")
                    .add("e", unaryOperation.operand.accept(this));
        }

        return null;
    }

    @Override
    public ST visit(Assignment assignment) {
        var variableSetST = new ST("");
        if (assignment.name.token.getText().equalsIgnoreCase("self")) {
            variableSetST = templates.getInstanceOf("selfSet");
        } else if (assignment.name.getSymbol() instanceof LocalAttributeSymbol) {
            variableSetST = templates.getInstanceOf("localSet")
                    .add("offset", assignment.name.getSymbol().getOffset());
        } else {
            if (assignment.name.getSymbol().getFormal()) {
                variableSetST = templates.getInstanceOf("paramSet")
                        .add("offset", assignment.name.getSymbol().getOffset());
            } else {
                variableSetST = templates.getInstanceOf("attributeSet")
                        .add("offset", assignment.name.getSymbol().getOffset());
            }
        }

        return templates.getInstanceOf("assignment")
                .add("varSet", variableSetST)
                .add("e", assignment.value.accept(this));
    }

    @Override
    public ST visit(New new_) {
        var newST = new ST("");
        if (new_.type.token.getText().equalsIgnoreCase("SELF_TYPE")) {
            newST = templates.getInstanceOf("newSelfType");
        } else {
            newST = templates.getInstanceOf("newClass")
                    .add("className", new_.type.token.getText());
        }

        return newST;
    }

    @Override
    public ST visit(ExplicitDispatch explicitDispatch) {
        // Add the file name
        var ctx = explicitDispatch.ctx;
        while (! (ctx.getParent() instanceof CoolParser.ProgramContext))
            ctx = ctx.getParent();
        int fileNameIdx = addIfMissingStr(new File(Compiler.fileNames.get(ctx)).getName());

        // Add the parameters
        var paramsST = templates.getInstanceOf("sequence");
        if (explicitDispatch.params != null) {
            // Reverse the list
            LinkedList<Expression> reversedParams = new LinkedList<>();
            for (var param : explicitDispatch.params) {
                reversedParams.add(0, param);
            }

            for (var param : reversedParams) {
                paramsST.add("e",
                        templates.getInstanceOf("pushParam")
                                .add("e", param.accept(this)));
            }
        }

        // Decide what method to call
        TypeSymbol baseType;
        if (explicitDispatch.staticType != null) {
            baseType = explicitDispatch.staticType.getTypeSymbol();
        } else {
            baseType = explicitDispatch.obj.getType();
            if (baseType == SymbolTable.SELF_TYPE) {
                baseType = Utils.findBaseClass(explicitDispatch.method.getScope());
            }
        }

        // Look for the method in the class
        assert baseType != null;
        FunctionSymbol methodToCall = baseType.lookupMethod(explicitDispatch.method.token.getText());

        return templates.getInstanceOf("dispatch")
                .add("params", paramsST)
                .add("storeObject", explicitDispatch.obj.accept(this))
                .add("label", genLabel("dispatch"))
                .add("methodOffset", methodToCall.getOffset())
                .add("fileNameIdx", fileNameIdx)
                .add("lineNumber", explicitDispatch.token.getLine())
                .add("dispTableRef", explicitDispatch.staticType == null
                        ? "    lw      $t1 8($a0)"
                        : ("    la      $t1 " + explicitDispatch.staticType.token.getText() + "_dispTab"));
    }

    @Override
    public ST visit(ImplicitDispatch implicitDispatch) {
        // Add the file name
        var ctx = implicitDispatch.ctx;
        while (! (ctx.getParent() instanceof CoolParser.ProgramContext))
            ctx = ctx.getParent();
        int fileNameIdx = addIfMissingStr(new File(Compiler.fileNames.get(ctx)).getName());

        // Add the parameters
        var paramsST = templates.getInstanceOf("sequence");
        if (implicitDispatch.params != null) {
            // Reverse the list
            LinkedList<Expression> reversedParams = new LinkedList<>();
            for (var param : implicitDispatch.params) {
                reversedParams.add(0, param);
            }

            for (var param : reversedParams) {
                paramsST.add("e",
                        templates.getInstanceOf("pushParam")
                            .add("e", param.accept(this)));
            }
        }

        // Find the base class
        TypeSymbol baseType = Utils.findBaseClass(implicitDispatch.method.getScope());

        // Look for the method in the class
        assert baseType != null;
        FunctionSymbol methodToCall = baseType.lookupMethod(implicitDispatch.method.token.getText());

        return templates.getInstanceOf("dispatch")
                .add("params", paramsST)
                .add("storeObject", "    move    $a0 $s0")
                .add("label", genLabel("dispatch"))
                .add("methodOffset", methodToCall.getOffset())
                .add("fileNameIdx", fileNameIdx)
                .add("lineNumber", implicitDispatch.token.getLine())
                .add("dispTableRef", "    lw      $t1 8($a0)");
    }

    @Override
    public ST visit(If if_) {
        return templates.getInstanceOf("if_")
                .add("cond", if_.cond.accept(this))
                .add("thenBranch", if_.then.accept(this))
                .add("elseBranch", if_.else_.accept(this))
                .add("elseLabel", genLabel("else"))
                .add("endIfLabel", genLabel("endIf"));
    }

    @Override
    public ST visit(While while_) {
        return templates.getInstanceOf("while")
                .add("cond", while_.cond.accept(this))
                .add("e", while_.body.accept(this))
                .add("loopStartLabel", genLabel("loopStart"))
                .add("whileEndLabel", genLabel("whileEnd"));
    }

    @Override
    public ST visit(Let let) {
        var letInitsST = templates.getInstanceOf("sequence");
        for (var localDef : let.defs) {
            letInitsST.add("e", localDef.accept(this));
        }

        return templates.getInstanceOf("let")
                .add("letInits", letInitsST)
                .add("e", let.body.accept(this));
    }

    @Override
    public ST visit(Case case_) {
        // Add the file name
        var ctx = case_.ctx;
        while (! (ctx.getParent() instanceof CoolParser.ProgramContext))
            ctx = ctx.getParent();
        int fileNameIdx = addIfMissingStr(new File(Compiler.fileNames.get(ctx)).getName());

        // Set local endCase label
        String localEndCaseLabel = genLabel("endCase");

        // Form the case template
        var caseST = templates.getInstanceOf("case")
                .add("e", case_.expr.accept(this))
                .add("caseVarOffset", case_.branches.get(0).name.getSymbol().getOffset())
                .add("caseLabel", genLabel("case"))
                .add("endCaseLabel", localEndCaseLabel)
                .add("fileNameIdx", fileNameIdx)
                .add("lineNumber", case_.token.getLine());

        // Sort the branches by the class tag
        List<CaseBranch> branches = new ArrayList<>(case_.branches);
        branches = branches.stream().sorted((br1, br2) -> Integer.compare(br2.name.getSymbol().getType().getTag(), br1.name.getSymbol().getType().getTag())).toList();

        // Iterate through the branches
        var branchesST = templates.getInstanceOf("sequence");
        for (var branch : branches) {
            currEndCaseLabel = localEndCaseLabel;
            branchesST.add("e", branch.accept(this));
        }

        return caseST.add("branches", branchesST);
    }

    @Override
    public ST visit(CaseBranch caseBranch) {
        return templates.getInstanceOf("caseBranch")
                .add("endCaseLabel", currEndCaseLabel)
                .add("tag", caseBranch.name.getSymbol().getType().getTag())
                .add("maxTag", caseBranch.name.getSymbol().getType().getMaxTag())
                .add("e", caseBranch.body.accept(this))
                .add("caseBranchLabel", genLabel("caseBranch"));
    }

    @Override
    public ST visit(Block block) {
        var blockST = templates.getInstanceOf("sequence");
        for (var e : block.expressions) {
            blockST.add("e", e.accept(this));
        }

        return blockST;
    }

    @Override
    public ST visit(Int int_) {
        // Extract the number
        int value = Integer.parseInt(int_.token.getText());

        // Add it to the data section (intConst)
        addIfMissingInt(value);

        return templates.getInstanceOf("literal")
                .add("type", "int")
                .add("value", value);
    }

    @Override
    public ST visit(String_ string) {
        // Extract the string
        String value = string.token.getText();

        // Add it to the data section (strConst)
        int idx = addIfMissingStr(value);

        return templates.getInstanceOf("literal")
                .add("type", "str")
                .add("value", idx);
    }

    @Override
    public ST visit(Bool bool) {
        // Extract the string
        String value = bool.token.getText();

        return templates.getInstanceOf("literal")
                .add("type", "bool")
                .add("value", value.equalsIgnoreCase("true") ? 1 : 0);
    }

    @Override
    public ST visit(Type type) {
        return null;
    }

    @Override
    public ST visit(Variable variable) {
        if (variable.token.getText().equals("self")) {
            return new ST("    move    $a0 $s0");
        }

        Symbol symbol = variable.getScope().lookup(variable.token.getText());
        if (symbol instanceof LocalAttributeSymbol) {
            return templates.getInstanceOf("localGet").add("offset", ((IdSymbol) symbol).getOffset());
        } else if (symbol instanceof IdSymbol) {
            if (((IdSymbol) symbol).getFormal()) {
                return templates.getInstanceOf("paramGet").add("offset", ((IdSymbol) symbol).getOffset());
            }

            return templates.getInstanceOf("attributeGet").add("offset", ((IdSymbol) symbol).getOffset());
        }

        // Should never get here
        throw new RuntimeException("Variable is not of type IdSymbol or its subclasses.");
    }
}
