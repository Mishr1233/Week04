package org.example.warehouse_management;

public class Furniture extends WarehouseItem{

    //Constructor
    public Furniture(String name){
        super(name);
    }

    //toString function to get name of item
    public String toString(){
        return "Furniture :"+getItem();
    }
}
