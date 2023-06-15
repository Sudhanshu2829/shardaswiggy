package org.example;

public class Restro {
    String restroID;
    String restroName;
    String restroAddress;
    Dish[] menu=new Dish[3];

    Restro(String id, String name, String addr){
        this.restroID=id;
        this.restroName=name;
        this.restroAddress=addr;
        this.menu=new Dish[3];
    }

    public void setMenu(Dish[] menu) {
        this.menu = menu;
    }

    public String getRestroID() {
        return restroID;
    }

    public String getRestroName() {
        return restroName;
    }

    public Dish[] getMenu() {
        return menu;
    }

    public String getRestroAddress() {
        return restroAddress;
    }
}
