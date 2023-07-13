package model;

import java.util.LinkedList;
import java.util.List;

public class Product {
    private String name;
    private int price;
    private int amount;
    private int id;

    public Product(String name, int price, int amount, int id) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Name: " + name  +
                ", price: " + price +
                "$, amount: " + amount +
                ", id: " + id;
    }
}
