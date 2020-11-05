package kap05;

import java.util.Scanner;

public class MaximumTest {

    public static void main(String... args){
        try (final Scanner scanner =  new Scanner(System.in)){
            System.out.print("First number: ");
            final int a = scanner.nextInt();
            System.out.print("Second number: ");
            final int b= scanner.nextInt();
            System.out.println("Biggest number is " + (a > b ? a : b));    
        }
    }
    
}
