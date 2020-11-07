package kap07;

public class ThirdDoubleTest {

    public static void main(String... args) {
        float a = 1.0E6f;
        float b = 1.0E7f;
        float c = 1.0E8f;

        System.out.println((a + 1.0f) - a);
        System.out.println((b + 1.0f) - b);
        System.out.println((c + 1.0f) - c);
    }

}
