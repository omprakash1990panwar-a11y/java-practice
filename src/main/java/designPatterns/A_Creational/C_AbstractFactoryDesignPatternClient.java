package designPatterns.A_Creational;

 /**
 ┌─────────────────────────────────────────────────────────────────────────────────────────────┐
 │                              ABSTRACT FACTORY EXAMPLE                                        │
 └─────────────────────────────────────────────────────────────────────────────────────────────┘


                             ┌────────────────────────────────────┐
                             │             Employee               │
                             │             «interface»            │
                             ├────────────────────────────────────┤
                             │ + salary() : int                   │
                             │ + name()   : String                │
                             └─────────────────┬──────────────────┘
                                               │
                                            implements
                                               │
                     ┌─────────────────────────┼─────────────────────────┐
                     │                         │                         │
                     ▼                         ▼                         ▼
         ┌──────────────────────┐  ┌──────────────────────┐  ┌──────────────────────┐
         │   AndroidDeveloper   │  │    WebDeveloper      │  │       Manager        │
         │   «concrete class»   │  │    «concrete class»  │  │    «concrete class»  │
         ├──────────────────────┤  ├──────────────────────┤  ├──────────────────────┤
         │ + salary() : int     │  │ + salary() : int     │  │ + salary() : int     │
         │ + name() : String    │  │ + name() : String    │  │ + name() : String    │
         │                      │  │                      │  │                      │
         │ salary = 10000       │  │ salary = 8000        │  │ salary = 100000      │
         └──────────────────────┘  └──────────────────────┘  └──────────────────────┘
                    ▲                         ▲                         ▲
                    │                         │                         │
                  creates                   creates                   creates
                    │                         │                         │
                    │                         │                         │
         ┌──────────┴─────────────┐  ┌────────┴─────────────┐  ┌────────┴───────────┐
         │AndroidDeveloperFactory │  │ WebDeveloperFactory  │  │ ManagerFactory     │
         │ «concrete factory»     │  │ «concrete class»     │  │ «concrete class»   │
         ├────────────────────────┤  ├──────────────────────┤  ├────────────────────┤
         │ + createEmployee()     │  │ + createEmployee()   │  │ + createEmployee() │
         │   : Employee           │  │   : Employee         │  │   : Employee       │
         │ + name() : String      │  │ + name() : String    │  │ + name() : String  │
         └──────────┬─────────────┘  └────────┬─────────────┘  └────────┬───────────┘
                    │                         │                         │
                    │                         │                         │
                    └─────────────────────────┼─────────────────────────┘
                                              │
                                            extends
                                              │
                                              ▼
                             ┌─────────────────────────────────────┐
                             │      EmployeeAbstractFactory        │
                             │          «abstract class»           │
                             ├─────────────────────────────────────┤
                             │ + createEmployee() : Employee       │
                             │ + name() : String                   │
                             └─────────────────┬───────────────────┘
                                               ▲
                                               │
                                              extends
                                               │
                     ┌─────────────────────────┼─────────────────────────┐
                     │                         │                         │
                     │                         │                         │
         AndroidDeveloperFactory     WebDeveloperFactory       ManagerFactory
         «concrete factory»          «concrete factory»        «concrete factory»


*/

/****************************************  Employee interface ***********************************************/
interface Employee {

    int salary();

    String name();
}


/** AndroidDeveloper, WebDeveloper and Manager become Concrete Classes by implementing Employee interface. */
class AndroidDeveloper implements Employee {

    @Override
    public int salary() {
        return 10000;
    }

    @Override
    public String name() {
        return "Android Developer";
    }
}


class WebDeveloper implements Employee {

    @Override
    public int salary() {
        return 8000;
    }

    @Override
    public String name() {
        return "Web Developer";
    }
}


class Manager implements Employee {

    @Override
    public int salary() {
        return 100000;
    }

    @Override
    public String name() {
        return "Manager";
    }
}


/** Abstract Factory  Defines the common method for creating Employee objects. */
abstract class EmployeeAbstractFactory {

    public abstract Employee createEmployee();

}


/**  Concrete Factory  Creates AndroidDeveloper objects. */
class AndroidDeveloperFactory extends EmployeeAbstractFactory {
    @Override
    public Employee createEmployee()
    {
        return new AndroidDeveloper();
    }
}


/**             Concrete Factory Creates WebDeveloper objects.              */
class WebDeveloperFactory extends EmployeeAbstractFactory {

    @Override
    public Employee createEmployee()
    {
        return new WebDeveloper();
    }
}


/** Concrete Factory  Creates Manager objects. */
class ManagerFactory extends EmployeeAbstractFactory {

    @Override
    public Employee createEmployee()
    {
        return new Manager();
    }
}



/**
 * EmployeeFactory is a separate class. It receives an EmployeeAbstractFactory and delegates the object
    creation to that factory. It does NOT extend EmployeeAbstractFactory.at the run time it will check type
    of object passed

    (here WebDeveloperFactory, AndroidDeveloperFactory, ManagerFactory)

    and will call the appropriate factory method to create the object using Runtime Polymorphism Dynamic Binding.

    Note : - Loosely coupled design is achieved by using Abstract Factory Design Pattern.
    Parent abstract class/Interface reference is used to refer to a child concrete factory object.
    Object Creation decision is made at runtime from all
    the child classes which Implement abstract class or method.

 */


class MainEmployeeFactory {

    public Employee getEmployee(EmployeeAbstractFactory factory) {
        return factory.createEmployee();

    }
}


public class C_AbstractFactoryDesignPatternClient {

    public static void main(String[] args) {

        Employee employee = new MainEmployeeFactory().getEmployee(new AndroidDeveloperFactory());
        System.out.println("Employee: " + employee.name()+ ", Salary: " + employee.salary());

        Employee employee2 =new MainEmployeeFactory().getEmployee(new WebDeveloperFactory());
        System.out.println("Employee: " + employee2.name()+ ", Salary: " + employee2.salary());


        Employee employee3 =new MainEmployeeFactory().getEmployee(new ManagerFactory());
        System.out.println("Employee: " + employee3.name()+ ", Salary: " + employee3.salary());

    }
}