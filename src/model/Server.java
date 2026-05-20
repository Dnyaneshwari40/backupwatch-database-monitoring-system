package model;

public class Server {

    private int serverId;
    private String serverName;
    private String ipAddress;
    private double storageCapacity;
    private String status;

    // Default Constructor
    public Server() {

    }

    // Parameterized Constructor
    public Server(
            int serverId,
            String serverName,
            String ipAddress,
            double storageCapacity,
            String status
    ) {

        this.serverId = serverId;
        this.serverName = serverName;
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
        this.status = status;
    }

    // Getters and Setters

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public double getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(double storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}