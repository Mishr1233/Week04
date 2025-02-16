package org.example.annotation.exercise_problems;

//Parent class Animal
class Animal {
    //Method to be overridden in subclasses
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {
    //Overriding the makeSound() method from Animal class
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class useOverride{
    public static void main(String[] args) {
        //Instantiate Dog and call makeSound()
        Dog dog = new Dog();
        dog.makeSound();
    }
}
