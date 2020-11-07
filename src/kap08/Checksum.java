package kap08;

import java.util.Scanner;

public class Checksum {

    public static void main(String... args){
        try (final Scanner scanner = new Scanner(System.in)){
            System.out.print("Input positive number: ");
            long input = scanner.nextLong();
            long result = 0;
            while (input > 0) {
                result += (input % 10);
                input = input / 10;
            }
            System.out.println("Quersum is " +  result);
        }
    }
}
