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
            System.out.println("User registration");
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
                System.out.println("User Registered Successfully!");
            } else {
                System.out.println("Registration Failed. Try Again.");
            }
        } catch (Exception e) {
            System.out.println("Error occur");
        }
    }

    public void login() {
        try {
            System.out.println("User login");
            System.out.print("Enter Email: ");
            String userEmail = scanner.nextLine().trim();

            System.out.print("Enter Password: ");
            String userPass = scanner.nextLine();

            Optional<User> opt = userDAO.loginUser(userEmail, userPass);

            if (opt.isPresent()) {
                User user = opt.get();
                System.out.println("Welcome, " + user.getUserFirstName() + " " + user.getUserLastName() + "..!");
            } else {
                System.out.println("Invalid Credentials. Please Try Again.");
            }
        } catch (Exception e) {
            System.out.println("Error occur while log in.");
        }
    }

    public void deleteUser() {
        System.out.println("Delete user");
        try {
            System.out.print("Enter Email: ");
            String userEmail = scanner.nextLine().trim();

            System.out.print("Enter Password: ");
            String userPass = scanner.nextLine();

            if (userDAO.deleteUser(userEmail, userPass)) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Invalid credentials or user does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Error occur while updating t user.");
        }
    }

    public void updateUser() {
        System.out.println("Update Phone Number.");
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
                    System.out.println("Phone number updated successfully.");
                } else {
                    System.out.println("Error occur while updating phone number.");
                }
            } else {
                System.out.println("Invalid Credentials. Please Try Again.");
            }
        } catch (Exception e) {
            System.out.println("Error occur while updating user.");
        }
    }
}