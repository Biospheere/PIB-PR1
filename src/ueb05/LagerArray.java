package ueb05;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LagerArray implements LagerImpl {

  private Artikel[] artikelArray;

  public LagerArray(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Lager muss größer als 0 sein");
    }
    artikelArray = new Artikel[size];
  }

  public LagerArray() {
    this(10);
  }

  @Override
  public void legeAnArtikel(Artikel artikel) {
    if (isFull()) {
      throw new IllegalArgumentException("Lager ist voll");
    }
    if (getArtikelByNr(artikel.getArtikelNr()).isPresent()) {
      throw new IllegalArgumentException(
          String.format(
              "Der Artikel mit der Nummer %d existiert bereits in dem Lager",
              artikel.getArtikelNr()));
    }
    artikelArray[getArtikelAnzahl()] = artikel;
  }

  @Override
  public void entferneArtikel(int artikelNr) {
    for (int i = 0; i < artikelArray.length; i++) {
      if (artikelArray[i] != null && artikelArray[i].getArtikelNr() == artikelNr) {
        artikelArray[i] = artikelArray[getArtikelAnzahl() - 1];
        artikelArray[getArtikelAnzahl() - 1] = null;
      }
    }
    /*artikelArray = Arrays.stream(artikelArray)
    .filter(artikel -> artikel != null && artikel.getArtikelNr() != artikelNr)
    .toArray(size -> new Artikel[artikelArray.length]);*/
  }

  @Override
  public void bucheZugang(int artikelNr, int menge) {
    Optional<Artikel> artikel = getArtikelByNr(artikelNr);
    if (artikel.isEmpty()) {
      throw new NoSuchElementException(
          String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
    }
    artikel.get().bucheZugang(menge);
  }

  @Override
  public void bucheAbgang(int artikelNr, int menge) {
    Optional<Artikel> artikel = getArtikelByNr(artikelNr);
    if (artikel.isEmpty()) {
      throw new NoSuchElementException(
          String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
    }
    artikel.get().bucheAbgang(menge);
  }

  @Override
  public void aenderePreisAllerArtikel(double prozent) {
    /*
     * for (Artikel artikel : artikelArray) { if (artikel != null) { double change =
     * (prozent * artikel.getPrice()) / 100; double price = artikel.getPrice() +
     * change; if (price > 0) { artikel.setPrice(price); } } }
     */

    Arrays.asList(artikelArray)
        .forEach(
            artikel -> {
              double change = (prozent * artikel.getPrice()) / 100;
              double price = artikel.getPrice() + change;
              if (price > 0) {
                artikel.setPrice(price);
              }
            });
  }

  @Override
  public Optional<Artikel> getArtikel(int index) {
    Artikel artikel = artikelArray[index];
    if (artikel == null) {
      return Optional.empty();
    }
    return Optional.of(artikel);
  }

  @Override
  public int getArtikelAnzahl() {
    /*
     * int count = 0; for (Artikel artikel : artikelArray) { if (artikel != null) {
     * count++; } } return count;
     */
    return (int) Arrays.asList(artikelArray).stream().filter(artikel -> artikel != null).count();
  }

  @Override
  public int getLagerGroesse() {
    return artikelArray.length;
  }

  @Override
  public Optional<Artikel> getArtikelByNr(int artikelNr) {
    /*
     * for(Artikel artikel : artikelArray){ if(artikel.getArtikelNr() == artikelNr){
     * return artikel; } } return null;
     */
    return Arrays.asList(artikelArray).stream()
        .filter(artikel -> artikel != null && artikel.getArtikelNr() == artikelNr)
        .findFirst();
  }

  public boolean isFull() {
    return !((getArtikelAnzahl()) < getLagerGroesse());
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Arrays.asList(artikelArray).stream()
        .filter(artikel -> artikel != null)
        .forEach(artikel -> stringBuilder.append(artikel + "\n"));
    return stringBuilder.toString();
  }
}
