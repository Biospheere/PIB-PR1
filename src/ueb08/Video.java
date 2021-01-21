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

  /** @return the spieldauer */
  public int getSpieldauer() {
    return spieldauer;
  }

  /** @param spieldauer the spieldauer to set */
  public void setSpieldauer(int spieldauer) {
    if (spieldauer == 0) {
      throw new IllegalArgumentException("Spieldauer darf nicht 0 sein");
    }
    this.spieldauer = spieldauer;
  }

  /** @return the jahr */
  public int getJahr() {
    return jahr;
  }

  /** @param jahr the jahr to set */
  public void setJahr(int jahr) {
    if (jahr > 2020 || jahr < 1950) {
      throw new IllegalArgumentException("Jahr muss zwischen 1950 und 2020 liegen");
    }
    this.jahr = jahr;
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format("Titel: %s Spieldauer: %d Jahr: %d", titel, spieldauer, jahr);
  }
}
