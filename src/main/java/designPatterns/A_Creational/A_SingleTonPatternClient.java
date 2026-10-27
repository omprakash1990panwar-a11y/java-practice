package designPatterns.A_Creational;


class SingleTonPattern {
    // Static instance of the singleton
    private static SingleTonPattern instance;

    // Private constructor to prevent instantiation from outside
    private SingleTonPattern() {
        System.out.println("A_SingleTonPattern instance created");
    }

    // Public method to get the singleton instance
    public static SingleTonPattern getInstance() {
        if (instance == null) {
            synchronized (SingleTonPattern.class) {
                if (instance == null) {
                    instance = new SingleTonPattern();
                }
            }
        }
        return instance;
    }

    // Method to access singleton data
    public String getMessage() {
        return "This is a Singleton example";
    }

}

public class A_SingleTonPatternClient {
    public static void main(String[] args) {
        // Get singleton instance for the first time
        SingleTonPattern obj1 = SingleTonPattern.getInstance();

        // Get singleton instance again
        SingleTonPattern obj2 = SingleTonPattern.getInstance();

        // Access the method
        System.out.println(obj1.getMessage());

        // Check whether both references point to the same object
        System.out.println("obj1 == obj2 : " + (obj1 == obj2));

        // Print hash codes
        System.out.println("obj1 hashCode : " + obj1.hashCode());
        System.out.println("obj2 hashCode : " + obj2.hashCode());
    }
}