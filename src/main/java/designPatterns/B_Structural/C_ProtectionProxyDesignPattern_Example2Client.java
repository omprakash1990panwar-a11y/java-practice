package designPatterns.B_Structural;

interface Database {
    void delete();
}

class MySqlDatabase implements Database{
    @Override
    public void delete() {
        System.out.println("User Deleted");
    }
}

class DatabaseProxy implements Database{
    private MySqlDatabase mySqlDatabase;
    private String userRole;

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
        this.mySqlDatabase = new MySqlDatabase();
    }

    @Override
    public void delete() {
        // Add protection logic here admin can delete users but user cannot delete users
        if (userRole.equals("admin")) {
            System.out.println("Checking permissions...");
            mySqlDatabase.delete();
        } else {
            System.out.println("Access denied. Only admins can delete users.");
        }
    }
}




public class C_ProtectionProxyDesignPattern_Example2Client {

    public static void main(String[] args) {

        // Direct access to MySqlDatabase without proxy and Delete method is called directly
        MySqlDatabase mySqlDatabase = new MySqlDatabase();
        mySqlDatabase.delete(); // Should allow deletion

        // Accessing MySqlDatabase through the proxy with different user roles admin to perform delete operation
        Database adminProxy = new DatabaseProxy("admin");
        adminProxy.delete(); // Should allow deletion

        // Accessing MySqlDatabase through the proxy with different user roles user to perform delete operation
        Database userProxy = new DatabaseProxy("user");
        userProxy.delete(); // Should deny deletion
    }
}
