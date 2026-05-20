package main;

import dao.ServerDAO;
import model.Server;
import service.BackupService;
import service.MonitoringService;
import util.FileUtil;

import java.util.Scanner;

public class Dashboard {

    Scanner scanner =
            new Scanner(System.in);

    ServerDAO serverDAO =
            new ServerDAO();

    BackupService backupService =
            new BackupService();

    MonitoringService monitoringService =
            new MonitoringService();

    int lastServerId = 0;
    double lastBackupSize = 0;
    String lastStatus = "SUCCESS";

    public void showMenu() {

        int choice;

        do {

            System.out.println(
                    "\n===== DATABASE BACKUP SYSTEM ====="
            );

            System.out.println(
                    "1. Add Server"
            );

            System.out.println(
                    "2. View Servers"
            );

            System.out.println(
                    "3. Update Server"
            );

            System.out.println(
                    "4. Delete Server"
            );

            System.out.println(
                    "5. Schedule Backup"
            );

            System.out.println(
                    "6. View Backup History"
            );

            System.out.println(
                    "7. Monitoring Dashboard"
            );

            System.out.println(
                    "8. Save Backup Logs"
            );

            System.out.println(
                    "9. Exit"
            );

            System.out.print(
                    "Choose Option: "
            );

            choice =
                    scanner.nextInt();

            switch (choice) {

                case 1:
                    addServer();
                    break;

                case 2:
                    serverDAO.viewServers();
                    break;

                case 3:
                    updateServer();
                    break;

                case 4:
                    deleteServer();
                    break;

                case 5:
                    scheduleBackup();
                    break;

                case 6:
                    backupService.viewHistory();
                    break;

                case 7:
                    monitoringService
                            .showDashboard();
                    break;

                case 8:
                    saveBackupLogs();
                    break;

                case 9:
                    System.out.println(
                            "Exiting..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid Choice!"
                    );
            }

        } while (choice != 9);
    }

    public void addServer() {

        scanner.nextLine();

        System.out.print(
                "Enter Server Name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "Enter IP Address: "
        );

        String ip =
                scanner.nextLine();

        System.out.print(
                "Enter Storage Capacity: "
        );

        double storage =
                scanner.nextDouble();

        scanner.nextLine();

        System.out.print(
                "Enter Status: "
        );

        String status =
                scanner.nextLine();

        Server server =
                new Server();

        server.setServerName(name);
        server.setIpAddress(ip);
        server.setStorageCapacity(storage);
        server.setStatus(status);

        serverDAO.addServer(server);
    }

    public void updateServer() {

        System.out.print(
                "Enter Server ID: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "Enter New Status: "
        );

        String status =
                scanner.nextLine();

        serverDAO.updateServer(
                id,
                status
        );
    }

    public void deleteServer() {

        System.out.print(
                "Enter Server ID: "
        );

        int id =
                scanner.nextInt();

        serverDAO.deleteServer(id);
    }

    public void scheduleBackup() {

        System.out.print(
                "Enter Server ID: "
        );

        int serverId =
                scanner.nextInt();

        System.out.print(
                "Enter Backup Size: "
        );

        double size =
                scanner.nextDouble();

        backupService.scheduleBackup(
                serverId,
                size
        );

        lastServerId =
                serverId;

        lastBackupSize =
                size;
    }

    public void saveBackupLogs() {

        FileUtil.saveBackupLog(
                lastServerId,
                lastStatus,
                lastBackupSize
        );
    }
}