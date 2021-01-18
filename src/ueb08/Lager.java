package ueb08;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Lager {

  private Artikel[] artikelArray;
  private String ort;

  public Lager(int size, String ort) {
    if (size <= 0) {
      throw new IllegalArgumentException("Lager muss größer als 0 sein");
    }
    setLagerOrt(ort);
    artikelArray = new Artikel[size];
  }

  public Lager(String ort) {
    this(10, ort);
  }

  public void legeAnArtikel(Artikel artikel) {
    if (isFull()) {
      throw new IllegalArgumentException("Lager ist voll");
    }
    if (getArtikelByNr(artikel.getArtikelNr()) != null) {
      throw new IllegalArgumentException(
          String.format("Der Artikel mit der Nummer %d existiert bereits in dem Lager", artikel.getArtikelNr()));
    }
    artikelArray[getArtikelAnzahl()] = artikel;
  }

  public void entferneArtikel(int artikelNr) {
    for (int i = 0; i < artikelArray.length; i++) {
      if (artikelArray[i] != null && artikelArray[i].getArtikelNr() == artikelNr) {
        artikelArray[i] = artikelArray[getArtikelAnzahl() - 1];
        artikelArray[getArtikelAnzahl() - 1] = null;
        return;
      }
    }
    throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
  }

  public void bucheZugang(int artikelNr, int menge) {
    Artikel artikel = getArtikelByNr(artikelNr);
    if (artikel == null) {
      throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
    }
    artikel.bucheZugang(menge);
  }

  public void bucheAbgang(int artikelNr, int menge) {
    Artikel artikel = getArtikelByNr(artikelNr);
    if (artikel == null) {
      throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
    }
    artikel.bucheAbgang(menge);
  }

  public void aenderePreisAllerArtikel(double prozent) {
    for (Artikel artikel : artikelArray) {
      if (artikel != null) {
        artikel.aenderePreis(prozent);
      }
    }
  }

  public Artikel getArtikel(int index) {
    Artikel artikel = artikelArray[index];
    return artikel == null ? null : artikel;
  }

  public int getArtikelAnzahl() {
    int count = 0;
    for (Artikel artikel : artikelArray) {
      if (artikel != null) {
        count++;
      }
    }
    return count;
  }

  public int getLagerGroesse() {
    return artikelArray.length;
  }

  public String getLagerOrt() {
    return ort;
  }

  public void setLagerOrt(String ort) {
    if (ort == null || ort.trim().isBlank()) {
      throw new IllegalArgumentException("Art darf nicht null sein");
    }
    this.ort = ort.trim();
  }

  public Artikel getArtikelByNr(int artikelNr) {
    for (Artikel artikel : artikelArray) {
      if (artikel != null && artikel.getArtikelNr() == artikelNr) {
        return artikel;
      }
    }
    return null;
  }

  public boolean isFull() {
    return !((getArtikelAnzahl()) < getLagerGroesse());
  }

  public void ausgebenBestandsListe() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Lagerort: " + ort + "\n"); 
    stringBuilder.append("Artnr Beschreibung Preis Bestand Gesamt\n");
    double sumPrice = 0;
    for(Artikel artikel : artikelArray){
      if(artikel != null){
        sumPrice += artikel.getBestand() * artikel.getPrice();
        stringBuilder.append(String.format("%d %s %f %d %f\n", artikel.getArtikelNr(), artikel.getArt(), artikel.getPrice(), artikel.getBestand(), artikel.getBestand() * artikel.getPrice()));
      }
    }
    stringBuilder.append("Gesamtwer: " + sumPrice);
    System.out.println(stringBuilder.toString());
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Arrays.asList(artikelArray).stream().filter(artikel -> artikel != null)
        .forEach(artikel -> stringBuilder.append(artikel + "\n"));
    return stringBuilder.toString();
  }
}
