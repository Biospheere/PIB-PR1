package kap07;

public class TypeValueLimit {

    public static void main(String... args) {
        System.out.printf("Double: %s ... %s\n", Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.printf("Float: %s ... %s\n", Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("Long: %s ... %s\n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("Integer: %s ... %s\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("Short: %s ... %s\n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("Byte: %s ... %s\n", Byte.MIN_VALUE, Byte.MAX_VALUE);

        System.out.printf("Float Infinity: %s ... %s\n", Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
        System.out.printf("Double Infinity: %s ... %s\n", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        System.out.printf("Float NaN: %s\n", Float.NaN);
        System.out.printf("Double NaN: %s\n", Double.NaN);

        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("-1.0 / 0.0 = " + -1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("1.0 / 0.0 + -1.0 / 0.0 = " + (1.0 / 0.0 + -1.0 / 0.0));
    }

}