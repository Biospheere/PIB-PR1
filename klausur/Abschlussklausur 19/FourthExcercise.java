public class FourthExcercise {

    public static void main(String... args) {
        System.out.println(isDifferent(new int[] { 1, 1, 1, 1, 1, 1 }));
        System.out.println(isDifferent(new int[] { 1, 1, 1, 3, 1, 1 }));
        System.out.println(countCharacters(new char[] { '3', '%', 'A', 'i', 'J', 'M', '?' }));

    }

    public static boolean isDifferent(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static int countCharacters(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')) {
                count++;
            }
        }
        return count;
    }

}
