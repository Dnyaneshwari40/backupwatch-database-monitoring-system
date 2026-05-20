package service;

import dao.BackupDAO;
import model.Backup;

public class BackupService {

    BackupDAO backupDAO =
            new BackupDAO();

    public void scheduleBackup(
            int serverId,
            double backupSize
    ) {

        Backup backup =
                new Backup();

        backup.setServerId(
                serverId
        );

        backup.setBackupSize(
                backupSize
        );

        // Dummy Status
        backup.setBackupStatus(
                "SUCCESS"
        );

        backupDAO.scheduleBackup(
                backup
        );
    }

    public void viewHistory() {

        backupDAO.viewBackupHistory();
    }
}