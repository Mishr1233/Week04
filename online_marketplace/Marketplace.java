package org.example.online_marketplace;

class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }
}

// Interfaces representing categories
interface BookCategory {}
interface ClothingCategory {}
interface GadgetCategory {}

// Concrete classes for product categories
class Book implements BookCategory {

}

class Clothing implements ClothingCategory {

}

class Gadget implements GadgetCategory {

}

// Marketplace class with a generic method to apply discounts
class Marketplace {

    // Generic method to apply discount to any product
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
    }

    public static void main(String[] args) {
        // Creating products with different categories
        Product<BookCategory> book = new Product<>("Java Programming", 30.0, new Book());
        Product<ClothingCategory> clothing = new Product<>("T-shirt", 20.0, new Clothing());
        Product<GadgetCategory> gadget = new Product<>("Smartphone", 500.0, new Gadget());

        // Applying discounts
        applyDiscount(book, 10);      // 10% discount on book
        applyDiscount(clothing, 15);  // 15% discount on clothing
        applyDiscount(gadget, 5);     // 5% discount on gadget

        // Displaying discounted prices
        System.out.println("Discounted Price of Book: " + book.getPrice());
        System.out.println("Discounted Price of Clothing: " + clothing.getPrice());
        System.out.println("Discounted Price of Gadget: " + gadget.getPrice());
    }
}
