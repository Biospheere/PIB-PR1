public class SecondExcercise {

    public static void main(String... args){
        System.out.println(enthaeltKubik(54));
        System.out.println(enthaeltKubik(55));
    }

    /**
     * Prüft ob es für ein Zahl <code>n</code> gibt die durch eine Kubikzahl teilbar ist
     * @param n die eingebene Zahl
     * @return das Ergenis der genannten Bedingung
     */
    public static boolean enthaeltKubik(long n){
        if(n < 1){
            throw new IllegalArgumentException("Zahl muss positiv sein");
        }
        for(int i = 2; i <= n; i++){
            if(n % Math.pow(i, 3) == 0){
                return true;
            }
        }
        return false;
    }
    
}
