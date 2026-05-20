package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import model.Backup;

public class BackupDAO {

    // Schedule Backup
    public void scheduleBackup(
            Backup backup
    ) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO backups " +
                    "(server_id, backup_date, " +
                    "backup_status, backup_size) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(
                    1,
                    backup.getServerId()
            );

            ps.setString(
                    2,
                    LocalDateTime.now().toString()
            );

            ps.setString(
                    3,
                    backup.getBackupStatus()
            );

            ps.setDouble(
                    4,
                    backup.getBackupSize()
            );

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Backup Scheduled Successfully!"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Backup History
    public void viewBackupHistory() {

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM backups";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "\n===== BACKUP HISTORY ====="
            );

            while (rs.next()) {

                System.out.println(
                        "Backup ID: "
                        + rs.getInt("backup_id")
                );

                System.out.println(
                        "Server ID: "
                        + rs.getInt("server_id")
                );

                System.out.println(
                        "Date: "
                        + rs.getString("backup_date")
                );

                System.out.println(
                        "Status: "
                        + rs.getString("backup_status")
                );

                System.out.println(
                        "Backup Size: "
                        + rs.getDouble("backup_size")
                );

                System.out.println(
                        "----------------------"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}