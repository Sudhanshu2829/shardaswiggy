package org.example;

public class Invoice {
    Dish dish;
    int qty;
    Invoice(Dish d,int q){
        this.dish=d;
        this.qty=q;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQty() {
        return qty;
    }
}
