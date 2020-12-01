public class SecondExcercise {

    public static void main(String... args){
        System.out.println(nurGeradeZiffern(2468));
        System.out.println(nurGeradeZiffern(9356));

    }

    public static boolean nurGeradeZiffern(long zahl){
        while (zahl > 0) {
            if((zahl % 10) % 2 != 0){
                return false;
            }
            zahl = zahl / 10;
        }
        return true;
    }
    
}
