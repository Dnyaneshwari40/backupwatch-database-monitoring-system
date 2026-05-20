package util;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class FileUtil {

    public static void saveBackupLog(
            int serverId,
            String status,
            double backupSize
    ) {

        try {

            // Create logs folder
            File folder =
                    new File("logs");

            if (!folder.exists()) {

                folder.mkdir();
            }

            // Create file
            File file =
                    new File(
                            "logs/backup_logs.txt"
                    );

            if (!file.exists()) {

                file.createNewFile();
            }

            FileWriter writer =
                    new FileWriter(
                            file,
                            true
                    );

            writer.write(
                    "[" +
                    LocalDateTime.now()
                    + "]\n"
            );

            writer.write(
                    "Backup Scheduled\n"
            );

            writer.write(
                    "Server ID: "
                    + serverId
                    + "\n"
            );

            writer.write(
                    "Status: "
                    + status
                    + "\n"
            );

            writer.write(
                    "Backup Size: "
                    + backupSize
                    + " GB\n"
            );

            writer.write(
                    "----------------------\n"
            );

            writer.close();

            System.out.println(
                    "Backup Log Saved Successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error Saving Log!"
            );

            e.printStackTrace();
        }
    }
}