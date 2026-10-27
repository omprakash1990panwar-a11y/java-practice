package designPatterns.test;

import java.util.HashMap;
import java.util.Map;

interface Tree {
    void display(int x,int y);
}

class OakTree implements Tree {

    private final String color;
    private final String texture;

    public OakTree() {
        this.color = "Green";
        this.texture = "Oak";
    }

    @Override
    public void display(int x,int y) {
        System.out.println("Tree at "+ x+ ","+ y);

    }
}


class TreeFactory {

    private static final Map<String,Tree> cache = new HashMap<>();

    public static Tree getTree(String type) {
        if (!cache.containsKey(type)) {
            cache.put(type,new OakTree());
        }
        return cache.get(type);
    }
}


public class FlyweightDemo {

    public static void main(String[] args) {

        for (int i = 0;i < 5; i++) {

            Tree tree =TreeFactory.getTree("OAK");
            tree.display(i * 10,i * 20);
        }
    }
}