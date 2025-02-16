package org.example.reflection.intermediate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Define custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

//Apply @Author annotation to a class
@Author(name = "John Doe")
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void displayTitle() {
        System.out.println("Book Title: " + title);
    }
}

public class RetriveAnnotation{
    public static void main(String[] args) {
        try {
            //Retrieve the Book class
            Class<?> bookClass = Book.class;

            //Check if the Book class has the @Author annotation
            if (bookClass.isAnnotationPresent(Author.class)) {

                Author authorAnnotation = bookClass.getAnnotation(Author.class);

                //Display the name value from the annotation
                System.out.println("Author: " + authorAnnotation.name());
            } else {
                System.out.println("No @Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
