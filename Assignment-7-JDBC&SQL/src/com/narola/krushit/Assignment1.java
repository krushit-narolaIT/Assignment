package com.narola.krushit;

import com.narola.krushit.service.UserService;
import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\nWelcome to MyRide Service");
                System.out.println("1. Register as User");
                System.out.println("2. Login as User");
                System.out.println("3. Delete user");
                System.out.println("4. Update Phone Number");
                System.out.print("Enter your choice: ");

//                if (!scanner.hasNextLine()) {
//                    System.out.println("No input found. Exiting...");
//                    break;
//                }
                scanner.nextLine();
                String input = scanner.nextLine();

                if (!input.matches("\\d+")) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                int choice = Integer.parseInt(input);
                UserService userService = new UserService();

                switch (choice) {
                    case 1:
                        System.out.println("User registration selected.");
                        userService.registerUser();
                        break;

                    case 2:
                        System.out.println("User login selected.");
                        userService.login();
                        break;

                    case 3:
                        System.out.println("Delete user permanently");
                        userService.deleteUser();
                        return;

                    case 4:
                        System.out.println("Exiting MyRide Service. Thank you!");
                        userService.updateUser();
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
