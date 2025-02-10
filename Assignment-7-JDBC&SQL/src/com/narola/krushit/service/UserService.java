package com.narola.krushit.service;

import com.narola.krushit.dao.UserDAO;
import com.narola.krushit.entity.User;
import java.util.Optional;
import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);
    private final UserDAO userDAO = new UserDAO();

    public void registerUser() {
        try {
            System.out.print("Enter User First Name: ");
            String userFirstName = scanner.nextLine().trim();

            System.out.print("Enter User Last Name: ");
            String userLastName = scanner.nextLine().trim();

            System.out.print("Enter User Email: ");
            String userEmail = scanner.nextLine().trim();

            System.out.print("Enter User Password: ");
            String userPass = scanner.nextLine();

            System.out.print("Enter User Phone: ");
            String userPhone = scanner.nextLine().trim();

            User user = new User(userEmail, userPass, userFirstName, userLastName, userPhone);

            if (userDAO.registerUser(user)) {
                System.out.println("\n✅ User Registered Successfully!");
            } else {
                System.out.println("\nRegistration Failed. Try Again.");
            }
        } catch (Exception e) {
            System.out.println("⚠ Error: Unable to register user.");
        }
    }

    public void login() {
        try {
            System.out.print("Enter Email: ");
            String userEmail = scanner.nextLine().trim();

            System.out.print("Enter Password: ");
            String userPass = scanner.nextLine();

            Optional<User> opt = userDAO.loginUser(userEmail, userPass);

            if (opt.isPresent()) {
                User user = opt.get();
                System.out.println("\n✅ Welcome, " + user.getUserFirstName() + " " + user.getUserLastName() + "!");
            } else {
                System.out.println("\nInvalid Credentials. Please Try Again.");
            }
        } catch (Exception e) {
            System.out.println("⚠ Error: Unable to log in.");
        }
    }

    public void deleteUser() {
        try {
            System.out.print("Enter Email: ");
            String userEmail = scanner.nextLine().trim();

            System.out.print("Enter Password: ");
            String userPass = scanner.nextLine();

            if (userDAO.deleteUser(userEmail, userPass)) {
                System.out.println("\nUser deleted successfully.");
            } else {
                System.out.println("\nInvalid credentials or user does not exist.");
            }
        } catch (Exception e) {
            System.out.println("⚠ Error: Unable to delete user.");
        }
    }

    public void updateUser() {
        try {
            System.out.print("Enter Email: ");
            String userEmail = scanner.nextLine().trim();

            System.out.print("Enter Password: ");
            String userPass = scanner.nextLine();

            Optional<User> opt = userDAO.loginUser(userEmail, userPass);

            if (opt.isPresent()) {
                System.out.print("Enter New Phone Number: ");
                String newPhone = scanner.nextLine().trim();

                if (userDAO.updatePhone(userEmail, newPhone)) {
                    System.out.println("\nPhone number updated successfully.");
                } else {
                    System.out.println("\nFailed to update phone number.");
                }
            } else {
                System.out.println("\nInvalid Credentials. Please Try Again.");
            }
        } catch (Exception e) {
            System.out.println("⚠ Error: Unable to update user.");
        }
    }
}