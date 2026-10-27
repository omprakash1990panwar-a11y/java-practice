package designPatterns.B_Structural;

interface Pizza {
    String getDescription();
    int getCost();
}

abstract class PizzaDecorator implements Pizza{

    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

}

class CheezeDecorator extends PizzaDecorator {


    public CheezeDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " cheeze";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 50;
    }
}

class MargheritaPizza implements Pizza{
    @Override
    public String getDescription() {
        return "MargheritaPizza";
    }

    @Override
    public int getCost() {
        return 200;
    }
}

class OlivesDecorator extends PizzaDecorator{

    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " olives";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 100;
    }
}


class MashroomDecorator extends PizzaDecorator{

    public MashroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " mashroom";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }
}


public class G_DecoratorDesignPatternPizza_ExampleClient{

    public static void main(String[] args) {

        Pizza  margheritaPizza = new MargheritaPizza();
        System.out.println(margheritaPizza.getDescription() + " Cost: " + margheritaPizza.getCost());

        Pizza cheezePizzaMargherita = new CheezeDecorator(new MargheritaPizza());
        System.out.println(cheezePizzaMargherita.getDescription() + " Cost: " + cheezePizzaMargherita.getCost());

        Pizza cheezeOlivesMargheritaPizza = new OlivesDecorator(new CheezeDecorator(new MargheritaPizza()));
        System.out.println(cheezeOlivesMargheritaPizza.getDescription() + " Cost: " + cheezeOlivesMargheritaPizza.getCost());

        Pizza OlivesPizzaMargherita = new OlivesDecorator(new MargheritaPizza());
        System.out.println(OlivesPizzaMargherita.getDescription() + " Cost: " + OlivesPizzaMargherita.getCost());
    }
}
