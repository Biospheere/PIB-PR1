package ueb05;

import java.util.Optional;

public interface LagerImpl {

    void legeAnArtikel(Artikel artikel);

    void entferneArtikel(int artikelNr);

    void bucheZugang(int artikelNr, int menge);

    void bucheAbgang(int artikelNr, int menge);

    void aenderePreisAllerArtikel(double prozent);

    Optional<Artikel> getArtikel(int index);

    int getArtikelAnzahl();

    int getLagerGroesse();

    Optional<Artikel> getArtikelByNr(int artikelNr);

    @Override
    String toString();

    
}
