package ueb08;

public class Buch extends Artikel {

  private String titel;
  private String autor;
  private String verlag;

  public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
    super(artikelNr, "Medien", bestand, preis);
    this.titel = titel;
    this.autor = autor;
    this.verlag = verlag;
  }

  @Override
  public String getBeschreibung() {
    return autor + ": " + titel;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("Titel: %s Autor: %s Verlag: %s", titel, autor, verlag);
  }
}
