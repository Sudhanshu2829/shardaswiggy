package org.example;

public class User {
    String userName;
    Location location;

    double WalletAmount=1000;
    User(String u,Location l){
        this.userName=u;
        this.location=l;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Location getLocation() {
        return location;
    }

    public double getWalletAmount() {
        return WalletAmount;
    }
}
