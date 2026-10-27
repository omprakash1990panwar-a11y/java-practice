package designPatterns.B_Structural;

import java.util.*;

/*
 * ============================================================
 * FLYWEIGHT DESIGN PATTERN
 * ============================================================
 *
 * PURPOSE:
 * Reduce memory consumption by sharing common object data
 * instead of creating duplicate objects.
 *
 * INTRINSIC STATE:
 * Data that can be shared among multiple objects.
 * Example: tree name, color, and texture information.
 *
 * EXTRINSIC STATE:
 * Data that is unique to each object or supplied from outside.
 * Example: the x and y coordinates of each tree.
 *
 * IMPORTANT:
 * Intrinsic state is stored in the shared Flyweight object.
 * Extrinsic state is stored in each individual Tree object.
 * ============================================================
 */


/**
 he Flyweight Design Pattern is a structural design pattern that aims to reduce memory consumption by sharing
 common object data instead of creating duplicate objects.
 In the provided Java file D_FlyWeightDesignPatternClient.java, the Flyweight Design Pattern is implemented to
 demonstrate its usage.
 Here's a simplified explanation:

 Key Concepts:
 Intrinsic State: This refers to the data that can be shared among multiple objects. In the example,
 the intrinsic state is the tree's name, color, and texture information.

 Extrinsic State: This refers to the data that is unique to each object or supplied from outside.
 In the example, the extrinsic state is the x and y coordinates of each tree.

 How it works:
 The TreeBasic class represents the intrinsic state of the tree, which includes the name, color, and
 texture information.
 The TreeFactory class is responsible for creating and managing the shared TreeBasic objects. It uses
 a Map to cache the created objects, so that subsequent requests for the same intrinsic state can return
 the cached object instead of creating a new one.

 The Tree class represents the extrinsic state of the tree, which includes the x and y coordinates.
 The Forest class is the client that uses the Flyweight Design Pattern. It creates multiple trees with different
 extrinsic states (x and y coordinates) but shares the same intrinsic state (tree name, color, and texture).

 Benefits:
 Reduced memory consumption: By sharing the intrinsic state among multiple objects, the memory usage is reduced.
 Improved performance: The Flyweight Design Pattern avoids creating duplicate objects, which can improve
 performance in scenarios where objects are created and destroyed frequently.

 In the context of the provided Java file FlyweightDemo.java, the Flyweight Design Pattern is used to
 create multiple trees with different x and y coordinates but the same intrinsic state (tree type "OAK").
 This is demonstrated in the main method, where 5 trees are created and displayed with different coordinates
 but the same tree type.

*/


// Represents the available tree colors.
enum Color {
    GREEN,
    ORANGE
}

// Fixed Data Almost all object Having it.  Intrinsic type data or FlyWeight Design Class
class TreeBasic_INTRINSIC {

    private final String name;
    private final Color color;
    private final String otherTreeData;

    public TreeBasic_INTRINSIC(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    public void plant(int x, int y) {
        System.out.println(
                this + " is planted at (" + x + ", " + y + ")"
        );
    }

    @Override
    public String toString() {
        return "TreeType{" +
                "name='" + name + '\'' +
                ", otherTreeData='" + otherTreeData + '\'' +
                ", color=" + color +
                '}';
    }
}

// Dymanic Data which changes with every object Extrinsic state
class Tree_EXTRINSIC {

    private final int x;
    private final int y;
    private final TreeBasic_INTRINSIC type;

    // Setting up INTRINSIC Values Passed by the constructor, INTRINSIC + EXTRINSIC
    public Tree_EXTRINSIC(int x, int y, TreeBasic_INTRINSIC type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void plant() {
        type.plant(x, y);
    }
}



class TreeFactory {

    // Factory which give basic Intrinsic.
    // Cached data for basicTree like Color Enum, name , OtherTreeData with name reference.

    private static final Map<String, TreeBasic_INTRINSIC> treeTypeMap = new HashMap<>();

    public static TreeBasic_INTRINSIC getTreeType(String name, Color color, String otherTreeData) {

        TreeBasic_INTRINSIC result = treeTypeMap.get(name);

        if (result == null) {
            result = new TreeBasic_INTRINSIC(name, color, otherTreeData);
            treeTypeMap.put(name, result);
        }

        return result;
    }
}


class Forest {


    private final List<Tree_EXTRINSIC> treeEXTRINSICS = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {

        // Get INTRINSIC object Values From the cached Memory from Tree Factory HashMap
        TreeBasic_INTRINSIC type = TreeFactory.getTreeType(name, color, otherTreeData);

        // Combine INTRINSIC + EXTRINSIC values in Tree class constructor
        Tree_EXTRINSIC treeEXTRINSIC = new Tree_EXTRINSIC(x, y, type);

        treeEXTRINSICS.add(treeEXTRINSIC);
    }


    public void display() {
        for (Tree_EXTRINSIC treeEXTRINSIC : treeEXTRINSICS) {
            treeEXTRINSIC.plant();
        }
    }


    public int getTreeCount() {
        return treeEXTRINSICS.size();
    }
}


public class D_FlyWeightDesignPatternClient {


    static final int PLOT_SIZE = 500;
    static final int TREES_TO_PLANT = 10000;
    static final int TREE_TYPES = 2;



    public static void main(String[] args) {

        Forest forest = new Forest();

        for (int i = 0; i < (TREES_TO_PLANT / TREE_TYPES); i++) {

            // Condinates for Summer Oak
            int x = random (0, PLOT_SIZE);
            int y = random(0, PLOT_SIZE);

            // Condinates for Autumn Oak
            int x2 = random (0, PLOT_SIZE);
            int y2 = random(0, PLOT_SIZE);

            forest.plantTree(x,  y,  "Summer Oak",Color.GREEN, "Oak texture stub");
            forest.plantTree(x2, y2,"Autumn Oak", Color.ORANGE,"Autumn Oak texture stub");
        }


        forest.display();

        // Prints the total number of trees created.
        System.out.println(forest.getTreeCount() + " trees planted");

        System.out.println("-------------------------");
        System.out.println("Memory usage (illustrative estimates):");

        // Estimates memory used by individual Tree objects using an assumed object size.
        System.out.println("Tree size (estimated 8 bytes) * " + TREES_TO_PLANT);

        // Estimates memory used by the two shared TreeType objects.
        System.out.println("TreeType size (estimated 30 bytes) * " + TREE_TYPES);

        System.out.println("-------------------------");

        // Calculates estimated memory usage when common tree data is shared.
        int flyweightMemory =
                (TREES_TO_PLANT * 8 + TREE_TYPES * 30) / 1024;

        // Calculates estimated memory usage when each tree duplicates its type data.
        int withoutFlyweightMemory =
                (TREES_TO_PLANT * 38) / 1024;

        // Prints the estimated memory usage with and without the Flyweight Pattern.
        System.out.println("With Flyweight (estimated): " + flyweightMemory + " KB");
        System.out.println("Without Flyweight (estimated): " + withoutFlyweightMemory + " KB");
    }


    static int random(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}