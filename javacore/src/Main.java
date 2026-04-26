import model.Customer;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 7;
        String str = "a";
        String str1 = "a";
        System.out.println(str.equals(str1));

        swapNumber(a, b);

        System.out.println(a);
        System.out.println(b);
        //StringBuilder
        //StringBuffer


    }

    public static void swapNumber(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }



   // ------------Stack ------------------ | --------------------------------------------------------HEAP------------------------------------------
    /* main {PI = 3.14f
             c                             |                                                     new Customer("thanh", true);
                                           |                                                     new Customer {
                                                                                                            private String name = "Thanh";
        int a = 5;
        int b = 7;                                                                                               private boolean gender = true;
                                                                                                            private int age = 0;
         swapNumber(a, b);                                                                                                    private float balance = 0.0f;
         str                                                                                a
         str1                                                                               a         }
    }

    swapNumber(int a = 5, int b = 7) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
    recursive(1);                                                                                 "Thanh"
    recursive(n +1);
    recursive(n +1);
    recursive(n +1);
    recursive(n +1);
    recursive(n +1);
    recursive(n +1);
    recursive(n +1);
    Exception in thread "main" java.lang.StackOverflowError
    ....


    *
    *
    *
    *
    *
    *
    * */

}