package com.narola.krushit.dao;

import com.narola.krushit.entity.User;
import com.narola.krushit.utils.DBConnection;

import java.sql.*;
import java.util.Optional;

public class UserDAO {
    private final String INSERT_USER_DATA = "INSERT INTO users (user_email, pass, user_first_name, user_last_name, user_phone) VALUES (?, ?, ?, ?, ?)";
    private final String DELETE_USER_DATA_BY_EMAIL = "DELETE FROM users WHERE user_email = ?";
    private final String LOGIN_USER = "SELECT * FROM users WHERE user_email = ? AND pass = ?";
    private final String UPDATE_PHONE_NUMBER = "UPDATE users SET user_phone = ? WHERE user_email = ? ";

    public boolean registerUser(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt3 = conn.prepareStatement(INSERT_USER_DATA)) {

            stmt3.setString(1, user.getUserEmail());
            stmt3.setString(2, user.getPass());
            stmt3.setString(3, user.getUserFirstName());
            stmt3.setString(4, user.getUserLastName());
            stmt3.setString(5, user.getUserPhone());

            int res = stmt3.executeUpdate();

            if(res == 1){
                return true;
            } else {
                System.out.println("Oops..! Some error occur...!!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<User> loginUser(String userEmail, String userPass) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(LOGIN_USER)) {

            stmt.setString(1, userEmail);
            stmt.setString(2, userPass);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserEmail(rs.getString("user_email"));
                user.setUserFirstName(rs.getString("user_first_name"));
                user.setUserLastName(rs.getString("user_last_name"));
                user.setUserPhone(rs.getString("user_phone"));
                return Optional.of(user);
            } else {
                System.out.println("Invalid email or password.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUser(String userEmail, String userPass) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(LOGIN_USER);
             PreparedStatement stmt1 = conn.prepareStatement(DELETE_USER_DATA_BY_EMAIL)) {

            stmt.setString(1, userEmail);
            stmt.setString(2, userPass);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                stmt1.setString(1, userEmail);
                int cnt = stmt1.executeUpdate();
                return true;
            } else {
                System.out.println("Invalid email or password.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePhone(String userEmail, String phone) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_PHONE_NUMBER)) {

            stmt.setString(1, userEmail);
            stmt.setString(2, phone);

            int update = stmt.executeUpdate();

            if (update == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}