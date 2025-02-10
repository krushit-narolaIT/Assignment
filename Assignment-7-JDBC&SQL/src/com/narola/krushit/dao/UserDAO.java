package com.narola.krushit.dao;

import com.narola.krushit.entity.User;
import com.narola.krushit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO {
    private static final String INSERT_USER =
            "INSERT INTO users (user_email, pass, user_first_name, user_last_name, user_phone) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_USER =
            "DELETE FROM users WHERE user_email = ? AND pass = ?";
    private static final String LOGIN_USER =
            "SELECT * FROM users WHERE user_email = ? AND pass = ?";
    private static final String UPDATE_PHONE =
            "UPDATE users SET user_phone = ? WHERE user_email = ?";

    public boolean registerUser(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_USER)) {

            stmt.setString(1, user.getUserEmail());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getUserFirstName());
            stmt.setString(4, user.getUserLastName());
            stmt.setString(5, user.getUserPhone());

            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println("⚠ Error: Registration failed.");
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
                User user = new User(
                        rs.getString("user_email"),
                        rs.getString("pass"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_phone")
                );
                return Optional.of(user);
            }
        } catch (SQLException e) {
            System.err.println("⚠ Error: Login query failed.");
        }
        return Optional.empty();
    }

    public boolean deleteUser(String userEmail, String userPass) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_USER)) {

            stmt.setString(1, userEmail);
            stmt.setString(2, userPass);

            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println("⚠ Error: Failed to delete user.");
            return false;
        }
    }

    public boolean updatePhone(String userEmail, String newPhone) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_PHONE)) {

            stmt.setString(1, newPhone);
            stmt.setString(2, userEmail);

            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println("⚠ Error: Failed to update phone number.");
            return false;
        }
    }
}