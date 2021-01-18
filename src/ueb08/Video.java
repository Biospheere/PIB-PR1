package ueb08;

public class Video extends Artikel {

    private String titel;
    private int spieldauer;
    private int jahr;

    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        this.titel = titel;
        this.spieldauer = spieldauer;
        this.jahr = jahr;
    }

    @Override
    public String getBeschreibung() {
        return titel;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Titel: %s Spieldauer: %d Jahr: %d", titel, spieldauer, jahr);
    }

}
