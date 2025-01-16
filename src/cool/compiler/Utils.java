package cool.compiler;

import cool.structures.Scope;
import cool.structures.SymbolTable;
import cool.structures.TypeSymbol;

import java.util.*;

public class Utils {
    public static List<TypeSymbol> getInheritanceChainForType(TypeSymbol class_) {
        // Find the inheritance chain
        List<TypeSymbol> inheritanceChain = new LinkedList<>();

        TypeSymbol currClass = class_;
        while (true) {
            inheritanceChain.add(0, currClass);
            if (currClass == SymbolTable.OBJECT) {
                break;
            }

            currClass = (TypeSymbol) currClass.getParent();
        }

        return inheritanceChain;
    }

    public static boolean checkInheritanceLoop(TypeSymbol baseClass) {
        if (baseClass == null) {
            return false;
        }

        Set<String> visitedClasses = new HashSet<>();
        visitedClasses.add(baseClass.getName());

        TypeSymbol currClass = baseClass;
        while (true) {
            if (currClass.getParent() == null) {
                return false;
            }

            currClass = (TypeSymbol) currClass.getParent();

            // Check if the parent is in the set
            if (visitedClasses.contains(currClass.getName())) {
                return true;
            }

            // Add it to the set
            visitedClasses.add(currClass.getName());
        }
    }

    public static TypeSymbol findBaseClass(Scope scope) {
        Scope currScope = scope;
        while (!(currScope instanceof TypeSymbol)) {
            currScope = currScope.getParent();
            if (currScope == null) {
                return null;
            }
        }

        return (TypeSymbol) currScope;
    }

    // Returns -1 if the child is not a child of the parent
    public static int getDistanceFromParent(TypeSymbol child, TypeSymbol parent) {
        int dist = 0;
        while (child != parent) {
            if (child.getParent() == null) {
                return -1;
            }

            child = (TypeSymbol) child.getParent();
            ++dist;
        }

        return dist;
    }

    public static int getDistanceFromParent_checkSelfType(TypeSymbol baseClass, TypeSymbol child, TypeSymbol parent) {
        TypeSymbol newChild = (child == SymbolTable.SELF_TYPE) ? baseClass : child;
        TypeSymbol newParent = (parent == SymbolTable.SELF_TYPE) ? baseClass : parent;

        if (child == parent) {
            return 0;
        }

        if (parent == SymbolTable.SELF_TYPE) {
            return -1;
        }

        return getDistanceFromParent(newChild, parent);
    }

    public static TypeSymbol lowestCommonAncestor(TypeSymbol a, TypeSymbol b) {
        // Generate the parent chain for type a
        Set<TypeSymbol> aParents = new HashSet<>();
        TypeSymbol curr = a;
        while (curr != null) {
            aParents.add(curr);
            curr = (TypeSymbol) curr.getParent();
        }

        // Simulate the path for node b and check A's path at every step
        curr = b;
        while (curr != null) {
            if (aParents.contains(curr)) {
                return curr;
            }

            curr = (TypeSymbol) curr.getParent();
        }

        // Due to all objects inheriting Object, this return statement should be unreachable
        return null;
    }

    public static TypeSymbol lowestCommonAncestor_checkSelfType(TypeSymbol baseClass, TypeSymbol a, TypeSymbol b) {
        if (a == SymbolTable.SELF_TYPE && b == SymbolTable.SELF_TYPE) {
            return SymbolTable.SELF_TYPE;
        }

        return lowestCommonAncestor((a == SymbolTable.SELF_TYPE) ? baseClass : a, (b == SymbolTable.SELF_TYPE) ? baseClass : b);
    }
}
