package com.narola.krushit.service;

import com.narola.krushit.dao.UserDAO;
import com.narola.krushit.entity.User;

import java.util.Optional;
import java.util.Scanner;

public class UserService {

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Enter User First Name: ");
            String userFirstName = scanner.nextLine();

            System.out.println("Enter User Last Name: ");
            String userLastName = scanner.nextLine();

            System.out.println("Enter User Password: ");
            String userPass = scanner.nextLine();

            System.out.println("Enter User Email: ");
            String userEmail = scanner.nextLine();

            System.out.println("Enter User Phone: ");
            String userPhone = scanner.nextLine();

            User user = new User();
            user.setPass(userPass);
            user.setUserFirstName(userFirstName);
            user.setUserLastName(userLastName);
            user.setUserEmail(userEmail);
            user.setUserPhone(userPhone);

            UserDAO userDAO = new UserDAO();
            boolean isRegistered = userDAO.registerUser(user);

            if (isRegistered) {
                System.out.println("**************************************");
                System.out.println("*  User Registered Successfully...!!! ");
                System.out.println("**************************************");
            } else {
                System.out.println("**************************************");
                System.out.println("*     Oops..!!, Some error occur     *");
                System.out.println("**************************************");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while registering the user..!!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Email: ");
            String userEmail = scanner.nextLine();

            System.out.println("Enter Password: ");
            String userPass = scanner.nextLine();

            UserDAO userDAO = new UserDAO();
            Optional<User> opt = userDAO.loginUser(userEmail, userPass);

            if (opt.isPresent()) {
                User user = opt.get();
                System.out.println("*  Welcome " + user.getUserFirstName() + " " + user.getUserLastName() + " *");
            } else {
                System.out.println("*     Invalid Credentials Please Try Again     *");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while registering the user..!!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Email: ");
            String userEmail = scanner.nextLine();

            System.out.println("Enter Password: ");
            String userPass = scanner.nextLine();

            UserDAO userDAO = new UserDAO();
            boolean flag = userDAO.deleteUser(userEmail, userPass);

            if (flag) {
                System.out.println("*  User " + userEmail + " deleted Successfully *");
            } else {
                System.out.println("*     Invalid Credentials Please Try Again     *");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while registering the user..!!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public void updateUser() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Email: ");
            String userEmail = scanner.nextLine();

            System.out.println("Enter Password: ");
            String userPass = scanner.nextLine();

            UserDAO userDAO = new UserDAO();
            Optional<User> opt = userDAO.loginUser(userEmail, userPass);

            if (opt.isPresent()) {
                User user = opt.get();
                System.out.println("*  Welcome " + user.getUserFirstName() + " " + user.getUserLastName() + " *");
                System.out.println("Enter New Phone Number");
                String userPhone = scanner.nextLine();
                boolean flag = userDAO.updatePhone(user.getUserEmail(),userPhone);
                if(flag){
                    System.out.println("Phone number updated successfully");
                } else {
                    System.out.println("User not exist..");
                }
            } else {
                System.out.println("*     Invalid Credentials Please Try Again     *");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while registering the user..!!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

