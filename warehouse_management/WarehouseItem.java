package org.example.warehouse_management;

//Abstract class of warehouseItem
abstract class WarehouseItem{

    private  String item;

    //Constructor
    public WarehouseItem(String item){
        this.item=item;
    }

    //GetItem function
    public String getItem(){
        return this.item;
    }

    //toString function
    @Override
    public String toString() {
        return "Item: " + item;
    }

}
