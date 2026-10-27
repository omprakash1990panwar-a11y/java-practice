package designPatterns.A_Creational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


interface Cloneable<GameBotCharacters> {
    GameBotCharacters customizedClone();
}

class GameBotCharacters implements Cloneable<GameBotCharacters> {


    private String name;
    private int health;
    private int attackPower;
    private List<String> weapons;

    // Normal Parameterized constructor
    public GameBotCharacters(String name, int health, int attackPower ,List<String> weapons) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.weapons = weapons;
        System.out.println("GameBotCharacters created: " + name + ", Health: " + health + ", Attack Power: " + attackPower);
    }

    // Private Copy constructor for deep cloning
    private GameBotCharacters(GameBotCharacters gbc) {
        this.name = gbc.name;
        this.health = gbc.health;
        this.attackPower = gbc.attackPower;
        this.weapons = new ArrayList<>(gbc.weapons);
    }

    // Implement the customizedClone method using private copy constructor for deep cloning
    @Override
    public GameBotCharacters customizedClone() {
        return new GameBotCharacters(this);
    }

    // Override the toString method for better representation
    @Override
    public String toString() {
        return "GameBotCharacters{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                ", weapons=" + weapons +
                '}';
    }

    //  Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public List<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }
}



public class E_PrototypeDesignPatternClient {

    public static void main(String[] args) {

        // Create an instance of the original object
        GameBotCharacters original = new GameBotCharacters
                ("Original Object", 100, 50, new ArrayList<>(Arrays.asList("Riffel", "Bomb")));

        // Clone the original object
        GameBotCharacters cloned1 = original.customizedClone();
        GameBotCharacters cloned2 = original.customizedClone();

        cloned1.setWeapons(new ArrayList<>(Arrays.asList("Sword", "Shield")));
        cloned1.setAttackPower(100);
        cloned1.setHealth(99);
        cloned1.setName("Cloned Object 1");

        cloned2.setWeapons(new ArrayList<>(Arrays.asList("Axe", "Helmet")));
        cloned2.setAttackPower(80);
        cloned2.setHealth(85);
        cloned2.setName("Cloned Object 2");


        // Display the original and cloned objects
        System.out.println("Original: " + original);
        System.out.println("Cloned 1: " + cloned1);
        System.out.println("Cloned 2: " + cloned2);
    }
}
