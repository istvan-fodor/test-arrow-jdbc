package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("org.apache.arrow.driver.jdbc.ArrowFlightJdbcDriver");

            String url = "jdbc:arrow-flight-sql://localhost:50051?useEncryption=0";

            if (System.getenv("USE_TLS") != null) {
                url = "jdbc:arrow-flight-sql://localhost:50051?useEncryption=1" +
                        "&clientKey=test-tls/client1.key&clientCertificate=test-tls/client1.pem&tlsRootCerts=test-tls/ca.pem";
            }

            Properties p = new Properties();
            p.setProperty("user", "admin");
            p.setProperty("password", "password");
            Connection connection = DriverManager.getConnection(url, p);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            String query = "SELECT 1"; // Replace "your_table" with your actual table name
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)); // Adjust the index or use column names depending on your
                                                            // schema
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
