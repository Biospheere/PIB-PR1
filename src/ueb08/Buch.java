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

  /** @return the autor */
  public String getAutor() {
    return autor;
  }

  /** @param autor the autor to set */
  public void setAutor(String autor) {
    if (autor == null || autor.isBlank()) {
      throw new IllegalArgumentException("Autor darf nicht null sein");
    }
    this.autor = autor;
  }

  /** @return the verlag */
  public String getVerlag() {
    return verlag;
  }

  /** @param verlag the verlag to set */
  public void setVerlag(String verlag) {
    if (verlag == null || verlag.isBlank()) {
      throw new IllegalArgumentException("Verlag darf nicht null sein");
    }
    this.verlag = verlag;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("Titel: %s Autor: %s Verlag: %s", titel, autor, verlag);
  }
}
