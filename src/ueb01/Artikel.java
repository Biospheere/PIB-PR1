package ueb01;

public class Artikel {

  private final int artikelnr;
  private String art;
  private int bestand;

  /**
   * Konstruktor für die Artikel Klasse
   *
   * @param artikelnr die Artikelnummer des Artikel
   * @param art die Art des Artikel
   * @param bestand der Initalbestand des Artikel
   * @throws IllegalArgumentException Wenn <code>artikelnr</code> keine 4-stellige positive Zahl
   *     sein
   * @throws IllegalArgumentException Wenn <code>art</code> null oder leer ist
   * @throws IllegalArgumentException Wenn <code>bestand</code> kleiner 0 ist
   */
  public Artikel(int artikelnr, String art, int bestand) {
    if (art == null || art.isBlank()) {
      throw new IllegalArgumentException("Art darf nicht null sein");
    }
    if (artikelnr >= 1000 && artikelnr <= 9999) {
      this.artikelnr = artikelnr;
    } else {
      throw new IllegalArgumentException("Die Artikelnummer muss eine 4-stellige Zahl");
    }
    if (bestand < 0) {
      throw new IllegalArgumentException("Bestand muss größer als 0 sein");
    }
    this.art = art.trim();
    this.bestand = bestand;
  }

  public Artikel(int artikelnr, String art) {
    this(artikelnr, art, 0);
  }

  /**
   * Füge dem aktuellen Bestand die eingegebene Menge hinzu
   *
   * @param menge Die Anzahl der Element die zum Bestand hinzugefügt werden sollen
   * @throws IllegalArgumentException Wenn <code>menge</code> kleiner als 1 ist
   */
  public void bucheZugang(int menge) {
    if (menge < 1) {
      throw new IllegalArgumentException("Menge muss größer als 0 sein");
    }
    bestand += menge;
  }

  /**
   * Ziehe dem aktuellen Bestand die eingegebene Menge ab
   *
   * @param menge Die Anzahl der Elemente die vom Bestand entfernt werden soll
   * @throws IllegalArgumentException Wenn <code>menge</code> kleiner als 1 ist oder die Menge nach
   *     dem Abgang kleiner 0 wäre
   */
  public void bucheAbgang(int menge) {
    if (menge < 1) {
      throw new IllegalArgumentException("Menge muss größer als 0 sein");
    }
    if (bestand - menge < 0) {
      throw new IllegalArgumentException("Bestand muss nach Abgang größer 0 sein");
    }
    bestand -= menge;
  }

  public int getArtikelnr() {
    return artikelnr;
  }

  public int getBestand() {
    return bestand;
  }

  public String getArt() {
    return art;
  }

  public void setArt(String art) {
    if (art == null || art.isBlank()) {
      throw new IllegalArgumentException("Art darf nicht null sein");
    }
    this.art = art.trim();
  }

  @Override
  public String toString() {
    return "Artikel: " + artikelnr + " Art: " + art + " Bestand: " + bestand;
  }
}
