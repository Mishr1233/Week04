package org.example.custom_exception;

//Custom exception
class InvalidAgeException extends Exception{

    public InvalidAgeException(String message){
        super(message);
    }
}

public class CustomException {


    //Checking valid age
    public static void validateAge(int age) throws InvalidAgeException{

        if(age>=18){
            System.out.println("Access granted!");
        }else {
            throw new InvalidAgeException("Access denied!");
        }

    }

    public static void main(String[] args) {

        try {
            validateAge(10);

        } catch (InvalidAgeException e) {
            System.out.println("Exception :"+e.getMessage());
        }
    }
}
