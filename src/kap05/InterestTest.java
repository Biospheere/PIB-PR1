package kap05;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestTest {

    private static final int DAYS_YEAR = 365;

    public static void main(String... args) {
        final Scanner scanner = new Scanner(System.in);
        final NumberFormat formatter = new DecimalFormat("#0.00");     
        while (true) {
            System.out.print("Capital: ");
            final double capital = scanner.nextDouble();
            System.out.print("Interest rate: ");
            final double interestRate = scanner.nextDouble();
            System.out.print("Days: ");
            final int days = scanner.nextInt();
            System.out.printf("The interest is %s€\n", formatter.format(capital * interestRate * days / (DAYS_YEAR * 100)));
            System.out.print("Continue? (y/n)");
            if (!scanner.next().startsWith("y")) {
                break;
            }
        }
        scanner.close();
    }

}
