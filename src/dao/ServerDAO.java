package dao;

import model.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServerDAO {

    // ADD SERVER
    public void addServer(Server server) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO servers " +
                    "(server_name, ip_address, " +
                    "storage_capacity, status) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1,
                    server.getServerName());

            ps.setString(2,
                    server.getIpAddress());

            ps.setDouble(3,
                    server.getStorageCapacity());

            ps.setString(4,
                    server.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Server Added Successfully!"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW SERVERS
    public void viewServers() {

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM servers";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "\n===== SERVER LIST ====="
            );

            while (rs.next()) {

                System.out.println(
                        "ID: "
                        + rs.getInt("server_id")
                );

                System.out.println(
                        "Name: "
                        + rs.getString("server_name")
                );

                System.out.println(
                        "IP Address: "
                        + rs.getString("ip_address")
                );

                System.out.println(
                        "Storage: "
                        + rs.getDouble(
                                "storage_capacity")
                );

                System.out.println(
                        "Status: "
                        + rs.getString("status")
                );

                System.out.println(
                        "--------------------"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE SERVER
    public void updateServer(
            int serverId,
            String status
    ) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "UPDATE servers " +
                    "SET status=? " +
                    "WHERE server_id=?";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, serverId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Server Updated Successfully!"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE SERVER
    public void deleteServer(
            int serverId
    ) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM servers " +
                    "WHERE server_id=?";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, serverId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Server Deleted Successfully!"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}