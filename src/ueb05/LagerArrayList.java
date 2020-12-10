package ueb05;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LagerArrayList implements LagerImpl {

    private final List<Artikel> artikelList;
    private final int maxElements;

    public LagerArrayList(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Lager muss größer als 0 sein");
        }
        artikelList = new ArrayList<>();
        maxElements = size;
    }

    public LagerArrayList() {
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
        artikelList.add(artikel);
        
    }

    @Override
    public void entferneArtikel(int artikelNr) {
        artikelList.removeIf(artikel -> artikel.getArtikelNr() == artikelNr);
    }

    @Override
    public void bucheZugang(int artikelNr, int menge) {
        Optional<Artikel> artikel =  getArtikelByNr(artikelNr);
        if (artikel.isEmpty()) {
            throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
        }
        artikel.get().bucheZugang(menge);
    }

    @Override
    public void bucheAbgang(int artikelNr, int menge) {
        Optional<Artikel> artikel =  getArtikelByNr(artikelNr);
        if (artikel.isEmpty()) {
            throw new NoSuchElementException(String.format("Der Artikel mit der Nummer %d existiert nicht", artikelNr));
        }
        artikel.get().bucheAbgang(menge);
    }

    @Override
    public void aenderePreisAllerArtikel(double prozent) {
        artikelList.forEach(artikel -> {
            double change = (prozent * artikel.getPrice()) / 100;
            double price = artikel.getPrice() + change;
            if (price > 0) {
                artikel.setPrice(price);
            }
        });
    }

    @Override
    public Optional<Artikel> getArtikel(int index) {
        if((index >= 0) && (index < artikelList.size())){
            return Optional.of(artikelList.get(index));
        }
        return Optional.empty();
    }

    @Override
    public int getArtikelAnzahl() {
        return artikelList.size();
    }

    @Override
    public int getLagerGroesse() {
        return maxElements;
    }

    public boolean isFull() {
        return !((artikelList.size()) < maxElements);
    }

    @Override
    public Optional<Artikel> getArtikelByNr(int artikelNr) {
        return artikelList.stream().filter(artikel -> artikel != null && artikel.getArtikelNr() == artikelNr).findFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        artikelList.forEach(artikel -> stringBuilder.append(artikel + "\n"));
        return stringBuilder.toString();
    }

}
