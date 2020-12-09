package ueb05;

public interface LagerImpl {

    void legeAnArtikel(Artikel artikel);

    void entferneArtikel(int artikelNr);

    void bucheZugang(int artikelNr, int menge);

    void bucheAbgang(int artikelNr, int menge);

    void aenderePreisAllerArtikel(double prozent);

    Artikel getArtikel(int index);

    int getArtikelAnzahl();

    int getLagerGroesse();

    Artikel getArtikelByNr(int artikelNr);

    @Override
    String toString();

    
}
