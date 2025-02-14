package org.example.exception_propagation_method;


public class ExceptionPropagationMethod {

    //Throws an ArithmeticException
    public static void method1() throws ArithmeticException {
        int result = 10 / 0;
    }

    //Calls method1
    public static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            //calls method2 which eventually calls method1
            method2();
        } catch (ArithmeticException e) {
            //Handle the exception and print a message
            System.out.println("Handled exception in main");
        }
    }
}
