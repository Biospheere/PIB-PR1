package kap07;

import java.util.Scanner;

public class LeapYearTest {

    public static void main(String... args){
        final Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Year: ");
            final int year = scanner.nextInt();
            final boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
            System.out.printf(isLeap ? "%s is leap year" : "%s is no leap year", year);
            System.out.print("\nContinue? (y/n)");
            if (!scanner.next().startsWith("y")) {
                break;
            }
        }
        scanner.close();
    }
    
}
