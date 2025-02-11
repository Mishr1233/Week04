package org.example.warehouse_management;

import java.util.List;

public class WarehouseManagement {

    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        //Create items
        Electronics phone=new Electronics("SmartPhone");
        Groceries sugar=new Groceries("Sugar");
        Furniture chair=new Furniture("Chair");

        Storage<Electronics> electronicsStorage=new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture>furnitureStorage=new Storage<>();

        electronicsStorage.add(phone);
        groceriesStorage.add(sugar);
        furnitureStorage.add(chair);

        System.out.println("Electronics Storage:");
        displayItems(electronicsStorage.get());

        System.out.println("\nGroceries Storage:");
        displayItems(groceriesStorage.get());

        System.out.println("\nFurniture Storage:");
        displayItems(furnitureStorage.get());


    }
}



