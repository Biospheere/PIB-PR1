package ueb07;

public class PWTest {

    public static void main(String[] args) {
        try {
            PatientenWarteschlange pw = new PatientenWarteschlange(10);
            pw.neuerPatient(4711, "Löw, Jogi"); 
            pw.neuerPatient(1234, "Kroos, Toni");
            pw.neuerPatient(1111, "Neuer, Manuel");
            pw.neuerPatient(2222, "Gnabry, Serge");
            System.out.println(pw); 
            System.out.println("Patient gelöscht: " + pw.entfernePatient(1234)); 
            Patient naechster = pw.derNaechsteBitte(); 
            System.out.println("Nächster Patient: " + naechster);
            System.out.println(pw);
        } catch (RuntimeException e) {  
           e.printStackTrace();
        }
    }

}
