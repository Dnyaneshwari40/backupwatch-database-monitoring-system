package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/backup_monitoring_db";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";
    // Yaha apna MySQL password likho

    public static Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection =
                    DriverManager.getConnection(
                            URL,
                            USERNAME,
                            PASSWORD
                    );

            System.out.println(
                    "Database Connected Successfully!"
            );

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "MySQL Driver Not Found!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Database Connection Failed!"
            );

            e.printStackTrace();
        }

        return connection;
    }
}