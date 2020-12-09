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
        if (getArtikelByNr(artikel.getArtikelNr()) != null) {
            throw new IllegalArgumentException(String
                    .format("Der Artikel mit der Nummer %d existiert bereits in dem Lager", artikel.getArtikelNr()));

        }
        artikelArray[getArtikelAnzahl()] = artikel;
    }

    @Override
    public void entferneArtikel(int artikelNr) {
        artikelArray = Arrays.stream(artikelArray).filter(artikel -> artikel != null && artikel.getArtikelNr() != artikelNr).toArray(size -> new Artikel[artikelArray.length]);
    }

    @Override
    public void bucheZugang(int artikelNr, int menge) {
        Artikel artikel = getArtikelByNr(artikelNr);
        if (artikel == null) {
            throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
        }
        artikel.bucheZugang(menge);
    }

    @Override
    public void bucheAbgang(int artikelNr, int menge) {
        Artikel artikel = getArtikelByNr(artikelNr);
        if (artikel == null) {
            throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
        }
        artikel.bucheAbgang(menge);
    }

    @Override
    public void aenderePreisAllerArtikel(double prozent) {
        /*
         * for (Artikel artikel : artikelArray) { if (artikel != null) { double change =
         * (prozent * artikel.getPrice()) / 100; double price = artikel.getPrice() +
         * change; if (price > 0) { artikel.setPrice(price); } } }
         */

        Arrays.asList(artikelArray).forEach(artikel -> {
            double change = (prozent * artikel.getPrice()) / 100;
            double price = artikel.getPrice() + change;
            if (price > 0) {
                artikel.setPrice(price);
            }
        });

    }

    @Override
    public Artikel getArtikel(int index) {
        return artikelArray[index];
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
    public Artikel getArtikelByNr(int artikelNr) {
        /*
         * for(Artikel artikel : artikelArray){ if(artikel.getArtikelNr() == artikelNr){
         * return artikel; } } return null;
         */
        Optional<Artikel> optional = Arrays.asList(artikelArray).stream()
                .filter(artikel -> artikel != null && artikel.getArtikelNr() == artikelNr).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }

    public boolean isFull() {
        return !((getArtikelAnzahl()) < getLagerGroesse());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(artikelArray).stream().filter(artikel -> artikel != null)
                .forEach(artikel -> stringBuilder.append(artikel + "\n"));
        return stringBuilder.toString();
    }

    public static void main(String... args) {
        LagerImpl lager = new LagerArray(10);
        System.out.println(lager.getArtikelAnzahl());
        System.out.println(lager.getArtikel(3));
    }

}
