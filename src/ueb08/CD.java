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

  /** @return the interpret */
  public String getInterpret() {
    return interpret;
  }

  /** @param interpret the interpret to set */
  public void setInterpret(String interpret) {
    if (interpret == null || interpret.isBlank()) {
      throw new IllegalArgumentException("Interpret darf nicht null sein");
    }
    this.interpret = interpret;
  }

  /** @return the titel */
  public String getTitel() {
    return titel;
  }

  /** @param titel the titel to set */
  public void setTitel(String titel) {
    if (titel == null || titel.isBlank()) {
      throw new IllegalArgumentException("Titel darf nicht null sein");
    }
    this.titel = titel;
  }

  /** @return the anzahlTitel */
  public int getAnzahlTitel() {
    return anzahlTitel;
  }

  /** @param anzahlTitel the anzahlTitel to set */
  public void setAnzahlTitel(int anzahlTitel) {
    if (anzahlTitel == 0) {
      throw new IllegalArgumentException("CD darf nicht leer sein");
    }
    this.anzahlTitel = anzahlTitel;
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format(
            "Titel: %s Interpret: %s Anzahl Musiktitel: %d", titel, interpret, anzahlTitel);
  }
}
