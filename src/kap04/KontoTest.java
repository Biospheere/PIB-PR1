package kap04;

public class KontoTest {

    public static void main(String... args){
        final Konto konto = new Konto("Niklas", 1, 1000);
        System.out.println("Current Balance: " + konto.getBalance());
        System.out.println("Owner: " + konto.getOwner());
        System.out.println("Balance after payin: " + konto.payIn(300));
        System.out.println("Balance after payout: " + konto.payOut(500));
        System.out.println(konto);
    }
    
}
