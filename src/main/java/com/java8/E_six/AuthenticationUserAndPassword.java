package com.java8.E_six;

import java.util.Scanner;
import java.util.function.Predicate;

public class AuthenticationUserAndPassword {

    public static void main(String[] args) {

        Predicate<User> p = user -> user.name.equals("omy")&& user.password.equals("password");
        System.out.println("Enter User Name And Password");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String password = scanner.nextLine();

        User user = new User(userName, password);

        if (p.test(user)) {
            System.out.println("User is authenticated");
        } else {
            System.out.println("User is not authenticated");
        }
    }

}
