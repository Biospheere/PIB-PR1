package kap08;

import java.util.Random;

public class RandomNumber {

    public static void main(String... args){
        final Random random = new Random();

        System.out.println("Random double");
        for(int i = 0; i < 5; i++){
            System.out.println(random.nextDouble());
        }

        System.out.println("\nRandom long");
        for(int i = 0; i < 5; i++){
            System.out.println(random.nextLong());
        }

        System.out.println("\nRandom int");
        for(int i = 0; i < 5; i++){
            System.out.println(random.nextInt());
        }

        System.out.println("\nRandom number from 0 to 100");
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(100) + "  ");
        }
    }
    
}
