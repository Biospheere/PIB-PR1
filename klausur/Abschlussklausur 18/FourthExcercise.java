public class FourthExcercise {

    public static void main(String... args) {
        System.out.println(isSorted(new int[] { 6,3,2,1 }));
    }

    /**
     * Überprüft ob das angegebene Array <code>arr</code> entweder
     * absteigend oder aufsteigend sortiert ist
     * @param arr 
     * @return ob <code>arr</code> sortiert ist
     */
    public static boolean isSorted(int[] arr) {
        System.out.println(arr.length);
        boolean isAscend = true;
        boolean isDescend = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isAscend = false;
                break;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.println(arr[i] + ":" + arr[i -1]);
            if (arr[i] > arr[i - 1]) {
                isDescend = false;
                break;
            }
        }
        return isAscend || isDescend;
    }

}
