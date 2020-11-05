package kap05;

import java.util.Scanner;

public class SumTest {

    public static void main(String... args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            long i = 1;
            long sum = 0;
            System.out.print("Input: ");
            final long n = scanner.nextLong();

            while (i <= n) {
                sum = sum + i;
                i++;
            }

            System.out.println("Summ: " + sum);
            System.out.println("With the sum formula: " + (n * (n + 1) / 2));
        }
    }

}
