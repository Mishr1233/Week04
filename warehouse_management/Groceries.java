package org.example.warehouse_management;

public class Groceries extends WarehouseItem{

    //Constructor
    public Groceries(String name){
        super(name);
    }
    //toString function to get name of item
    public String toString(){
        return "Groceries :"+getItem();
    }

}
