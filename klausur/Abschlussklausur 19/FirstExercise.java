public class FirstExercise {

    public static void main(String... args) {
        checkType('\uABBA');
        checkType(07777L);
        checkType(0X1001);
        checkType(1.001001E001F);
        checkExpression();
    }

    public static void checkType(Object obj) {
        System.out.println("Checking Type for " + obj);
        System.out.println("Boolean: " + Boolean.class.isInstance(obj));
        System.out.println("Short: " + Short.class.isInstance(obj));
        System.out.println("Char: " + Character.class.isInstance(obj));
        System.out.println("Int: " + Integer.class.isInstance(obj));
        System.out.println("Long: " + Long.class.isInstance(obj));
        System.out.println("Float: " + Float.class.isInstance(obj));
        System.out.println("Double: " + Double.class.isInstance(obj) + "\n");
    }

    public static void checkExpression() {
        int i = 15;
        long lo = 16L;
        float f = 3.7f;
        double d = 7.9;

        System.out.println(011 - 0X11);
        System.out.println(lo > 2 * d);
        System.out.println(lo = (int) (f + d));
        System.out.println(i / 10.0 - i / 10);
    }

}
