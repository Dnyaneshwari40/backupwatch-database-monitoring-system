package service;

import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MonitoringService {

    public void showDashboard() {

        try {

            Connection connection =
                    DBConnection.getConnection();

            // Total Servers
            String serverQuery =
                    "SELECT COUNT(*) " +
                    "AS total_servers " +
                    "FROM servers";

            PreparedStatement ps1 =
                    connection.prepareStatement(
                            serverQuery
                    );

            ResultSet rs1 =
                    ps1.executeQuery();

            int totalServers = 0;

            if (rs1.next()) {

                totalServers =
                        rs1.getInt(
                                "total_servers"
                        );
            }

            // Total Backups
            String backupQuery =
                    "SELECT COUNT(*) " +
                    "AS total_backups " +
                    "FROM backups";

            PreparedStatement ps2 =
                    connection.prepareStatement(
                            backupQuery
                    );

            ResultSet rs2 =
                    ps2.executeQuery();

            int totalBackups = 0;

            if (rs2.next()) {

                totalBackups =
                        rs2.getInt(
                                "total_backups"
                        );
            }

            // Success Backups
            String successQuery =
                    "SELECT COUNT(*) " +
                    "AS success_count " +
                    "FROM backups " +
                    "WHERE backup_status='SUCCESS'";

            PreparedStatement ps3 =
                    connection.prepareStatement(
                            successQuery
                    );

            ResultSet rs3 =
                    ps3.executeQuery();

            int successCount = 0;

            if (rs3.next()) {

                successCount =
                        rs3.getInt(
                                "success_count"
                        );
            }

            // Failed Backups
            String failedQuery =
                    "SELECT COUNT(*) " +
                    "AS failed_count " +
                    "FROM backups " +
                    "WHERE backup_status='FAILED'";

            PreparedStatement ps4 =
                    connection.prepareStatement(
                            failedQuery
                    );

            ResultSet rs4 =
                    ps4.executeQuery();

            int failedCount = 0;

            if (rs4.next()) {

                failedCount =
                        rs4.getInt(
                                "failed_count"
                        );
            }

            // Total Storage Used
            String storageQuery =
                    "SELECT SUM(backup_size) " +
                    "AS total_storage " +
                    "FROM backups";

            PreparedStatement ps5 =
                    connection.prepareStatement(
                            storageQuery
                    );

            ResultSet rs5 =
                    ps5.executeQuery();

            double totalStorage = 0;

            if (rs5.next()) {

                totalStorage =
                        rs5.getDouble(
                                "total_storage"
                        );
            }

            // Print Dashboard

            System.out.println(
                    "\n===== MONITORING DASHBOARD ====="
            );

            System.out.println(
                    "Total Servers: "
                    + totalServers
            );

            System.out.println(
                    "Total Backups: "
                    + totalBackups
            );

            System.out.println(
                    "Successful Backups: "
                    + successCount
            );

            System.out.println(
                    "Failed Backups: "
                    + failedCount
            );

            System.out.println(
                    "Total Storage Used: "
                    + totalStorage
                    + " GB"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}