package designPatterns.B_Structural;

import java.util.ArrayList;
import java.util.List;

/*
 * Component: Common interface for individual objects (Leaf)
 * and groups of objects (Composite).
 */
interface OrganizationComponent {

    void showDetails();
}

/*
 * Leaf: Represents an individual object that does not contain
 * other OrganizationComponent objects.
 *
 * Example: An Employee such as John or Venu.
 */
class Employee implements OrganizationComponent {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name);
    }
}

/*
 * Composite: Represents a group of objects that can contain
 * individual objects (Leaf) as well as other groups (Composite).
 *
 * Example: A Department can contain Employees and other Departments.
 */
class Department implements OrganizationComponent {

    private String name;

    // Stores individual Employees and/or other Departments.
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    // Adds an individual object or another group to this Department.
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {

        System.out.println("Department: " + name);

        // Displays the details of every object or subgroup.
        for (OrganizationComponent component : components) {
            component.showDetails();
        }
    }
}

/*
 * Client: Creates individual objects and groups, then uses
 * the common OrganizationComponent interface to display details.
 */
public class B_CompositeDesignPatternClient {

    public static void main(String[] args) {

        // Leaf: Individual Employee objects.
        Employee dev1 = new Employee("John");
        Employee dev2 = new Employee("Venu");

        // Composite: A group containing multiple Employee objects.
        Department engineering = new Department("Engineering");

        engineering.add(dev1);
        engineering.add(dev2);

        engineering.showDetails();
    }
}