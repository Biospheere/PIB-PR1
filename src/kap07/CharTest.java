package kap07;

public class CharTest {

    public static void main(String... args) {
        int i = 0;
        char c = ' ';

        while (c <= '\u3000') {
            System.out.print(c);
            c = (char) (c + 1);
            i++;
            if (i == 64) {
                System.out.println();
                i = 0;
            }
        } 
    }

}
