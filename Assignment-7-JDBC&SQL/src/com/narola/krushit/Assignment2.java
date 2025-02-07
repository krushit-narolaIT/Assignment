package com.narola.krushit;

import com.narola.krushit.utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment2 {
    public static void main(String[] args) throws SQLException {
        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try (Connection conn = DBConnection.getConnection();
             Statement st1 = conn.createStatement();) {

            String query1 = "INSERT INTO users VALUES ('abc@gmail.com', '123', 'abc', 'cde', '789654123')";
            String query2 = "INSERT INTO users VALUES ('bcd@gmail.com', '123', 'abc', 'cde', '789654123')";
            //it is not added because email id column is unique so all batch operations are rollback
            String query3 = "INSERT INTO users VALUES ('abc@gmail.com', '123', 'abc', 'cde', '789654123')";

            st1.executeQuery(query1);
            st1.executeQuery(query2);
            st1.executeQuery(query3);

            con.commit();

        } catch (SQLException e) {
            System.out.println("Roll Back");
            con.rollback();
            e.printStackTrace();
        }

    }
}
