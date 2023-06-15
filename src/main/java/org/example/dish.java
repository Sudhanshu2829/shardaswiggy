package org.example;

public class Dish {
    String restroID;
    String dishID;
    String dishName;
    int price;
    Dish(String rid, String did, String dname, int p){
        this.restroID=rid;
        this.dishID=did;
        this.dishName=dname;
        this.price=p;
    }

    public String getDishID(){
        return dishID;
    }

    public String getRestroID(){
        return restroID;
    }

    public String getDishName(){
        return dishName;
    }

    public int getPrice(){
        return price;
    }
}
