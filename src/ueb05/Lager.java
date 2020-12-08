package ueb05;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Lager {

    private final List<Artikel> artikelList;
    private final int maxElements;

    public Lager(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Lager muss größer als 0 sein");
        }
        artikelList = new ArrayList<>();
        maxElements = size;
    }

    public Lager() {
        this(10);
    }

    public void legeAnArtikel(Artikel artikel) {
        if (isFull()) {
            throw new IllegalArgumentException("Lager ist voll");
        }
        if (getArtikelByNr(artikel.getArtikelNr()).isPresent()) {
            throw new IllegalArgumentException(String
                    .format("Der Artikel mit der Nummer %d existiert bereits in dem Lager", artikel.getArtikelNr()));

        }
        artikelList.add(artikel);
    }

    public void entferneArtikel(int artikelNr) {
        artikelList.removeIf(artikel -> artikel.getArtikelNr() == artikelNr);
    }

    public void bucheZugang(int artikelNr, int menge) {
        Optional<Artikel> optional = getArtikelByNr(artikelNr);
        if (!optional.isPresent()) {
            throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
        }
        optional.get().bucheZugang(menge);
    }

    public void bucheAbgang(int artikelNr, int menge) {
        Optional<Artikel> optional = getArtikelByNr(artikelNr);
        if (!optional.isPresent()) {
            throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
        }
        optional.get().bucheAbgang(menge);
    }

    public void aenderePreisAllerArtikel(double prozent) {
        artikelList.forEach(artikel -> {
            double change = (prozent * artikel.getPrice()) / 100;
            double price = artikel.getPrice() + change;
            if (price > 0) {
                artikel.setPrice(price);
            }
        });
    }

    public Artikel getArtikel(int index) {
        return (index >= 0) && (index < artikelList.size()) ? artikelList.get(index) : null;
    }

    public int getArtikelAnzahl() {
        return artikelList.size();
    }

    public int getLagerGroesse() {
        return maxElements;
    }

    public boolean isFull() {
        return !((artikelList.size()) < maxElements);
    }

    public Optional<Artikel> getArtikelByNr(int artikelNr) {
        return artikelList.stream().filter(artikel -> artikel.getArtikelNr() == artikelNr).findFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        artikelList.forEach(artikel -> stringBuilder.append(artikel + "\n"));
        return stringBuilder.toString();
    }

}
