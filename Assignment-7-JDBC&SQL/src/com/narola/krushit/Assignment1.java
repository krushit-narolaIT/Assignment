package com.narola.krushit;

import com.narola.krushit.service.UserService;
import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        try {
            while (true) {
                System.out.println("\nWelcome to MyRide Service");
                System.out.println("1. Register as User");
                System.out.println("2. Login as User");
                System.out.println("3. Delete user");
                System.out.println("4. Update Phone Number");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("User registration selected.");
                        userService.registerUser();
                    }

                    case 2 -> {
                        System.out.println("User login selected.");
                        userService.login();
                    }

                    case 3 -> {
                        System.out.println("Delete user permanently.");
                        userService.deleteUser();
                    }

                    case 4 -> {
                        System.out.println("Update Phone Number.");
                        userService.updateUser();
                    }

                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}