package model;

public class Backup {

    private int backupId;
    private int serverId;
    private String backupDate;
    private String backupStatus;
    private double backupSize;

    // Default Constructor
    public Backup() {

    }

    // Getters and Setters

    public int getBackupId() {
        return backupId;
    }

    public void setBackupId(int backupId) {
        this.backupId = backupId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getBackupDate() {
        return backupDate;
    }

    public void setBackupDate(String backupDate) {
        this.backupDate = backupDate;
    }

    public String getBackupStatus() {
        return backupStatus;
    }

    public void setBackupStatus(String backupStatus) {
        this.backupStatus = backupStatus;
    }

    public double getBackupSize() {
        return backupSize;
    }

    public void setBackupSize(double backupSize) {
        this.backupSize = backupSize;
    }
}