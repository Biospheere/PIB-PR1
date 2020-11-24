public class FirstExercise {

    public static void main(String... args){
            checkType(01010101F);
            checkType('\uDEAD');
            checkType(+3.14159);
            checkType(7777777L);
            checkExpression();
    }

    public static void checkType(Object obj){
        System.out.println("Checking Type for " + obj);
        System.out.println("Boolean: " + Boolean.class.isInstance(obj));
        System.out.println("Short: " + Short.class.isInstance(obj));    
        System.out.println("Char: " + Character.class.isInstance(obj));
        System.out.println("Int: " + Integer.class.isInstance(obj));
        System.out.println("Long: " + Long.class.isInstance(obj));
        System.out.println("Float: " + Float.class.isInstance(obj));
        System.out.println("Double: " + Double.class.isInstance(obj) + "\n");
    }

    public static void checkExpression(){
        int i = 5;
        double d = 5.1;
        String s = "234";

        System.out.println(i/d < 1);
        System.out.println(s += 1);
        System.out.println(i - (i/3)*3);
        System.out.println(015L - 0X14);
    }
    
}
