package org.example.warehouse_management;

public class Electronics extends WarehouseItem{

    //Constructor
    public  Electronics(String name){
        super(name);

    }

    //Overriding function
    @Override
    public String toString(){
        return "Electronic :"+getItem();
    }
}
