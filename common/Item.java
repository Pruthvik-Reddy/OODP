package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {
    private String itemID;
    private String type;
    private String description;
    private double price;
    private int count;

    public Item(String itemID, String type, String description, double price, int count) {
        this.itemID = itemID;
        this.type = type;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public String getItemId(){
        return itemID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void reduceCount(int count){
        this.count = this.count -1;
    }

}