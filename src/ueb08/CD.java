package ueb08;

public class CD extends Artikel {

  private String interpret;
  private String titel;
  private int anzahlTitel;

  public CD(
      int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
    super(artikelNr, "Medien", bestand, preis);
    this.interpret = interpret;
    this.titel = titel;
    this.anzahlTitel = anzahlTitel;
  }

  @Override
  public String getBeschreibung() {
    return interpret + ": " + titel;
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format(
            "Titel: %s Interpret: %s Anzahl Musiktitel: %d", titel, interpret, anzahlTitel);
  }
}
