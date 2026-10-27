package designPatterns.A_Creational;

// Interfaces which contain send Message method
interface NotificationService {
    void sendMessage(String message);
}


// Implementation Classes for Notification Servies
class Calling implements NotificationService {

    @Override
    public void sendMessage(String message) {System.out.println("Sending Calling: " + message);
    }
}

class SMSService implements NotificationService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class EmailService implements NotificationService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}


// Factroy which crates the object of Notification Service based on the type

class NotificationFactory {

    public static NotificationService getNotificationService(String type) {

        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailService();

        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSService();

        } else if (type.equalsIgnoreCase("Calling")) {
            return new Calling();
        }

        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}


public class B_FactoryDesignPatternClient {

    public static void main(String[] args) {

        NotificationService email = NotificationFactory.getNotificationService("EMAIL");

        email.sendMessage("Welcome to our application!");

        NotificationService sms = NotificationFactory.getNotificationService("SMS");

        sms.sendMessage("Your OTP is 1234");

        NotificationService notification = NotificationFactory.getNotificationService("Calling");

        notification.sendMessage("You have a new message.");
    }
}
