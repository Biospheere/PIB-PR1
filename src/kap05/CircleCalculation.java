package kap05;

import java.util.Scanner;

public class CircleCalculation {

    public static void main(String... args){
        try (final Scanner scanner = new Scanner(System.in)){
            System.out.print("Input: ");
            final double radius = scanner.nextDouble();
            System.out.println("Surface: " + (Math.PI * (radius * radius)));
            System.out.println("Circumference: " + (Math.PI * 2 * radius));
        }
    }
    
}
