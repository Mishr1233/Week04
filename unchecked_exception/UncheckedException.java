package org.example.unchecked_exception;

public class UncheckedException {

    //divideTwoNumbers handle exception and print result
    public static void divideTwoNumbers(String a,String b){

        try {
            int num1=Integer.parseInt(a);
            int num2=Integer.parseInt(b);
            double result =num1/num2;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
      divideTwoNumbers("5","0");
      divideTwoNumbers("5","xyz");
    }
}
