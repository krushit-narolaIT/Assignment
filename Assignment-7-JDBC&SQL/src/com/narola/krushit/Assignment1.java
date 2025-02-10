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
                    case 1 -> userService.registerUser();
                    case 2 -> userService.login();
                    case 3 -> userService.deleteUser();
                    case 4 -> userService.updateUser();
                    case 5 -> {
                        System.out.println("Exiting...");
                        Thread.sleep(1000);
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