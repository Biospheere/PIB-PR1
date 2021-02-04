# 8. Übung

Sie erinnern sich hoffentlich noch an die Klassen Artikel und Lager aus einigen früheren Übungen?
Erweitern Sie Ihre korrigierten Klassen Artikel und Lager um die nachfolgend beschriebenen
Funktionalitäten. Von der Klasse Artikel sind Unterklassen CD, Video und Buch abzuleiten.

Die Unterklassen von Artikel sollen mindestens die folgenden Konstruktoren haben:

- CD(int artikelNr, int bestand, double preis, String interpret, String titel, int
    anzahlTitel)
- Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int
    jahr)
- Buch(int artikelNr, int bestand, double preis, String autor, String titel, String
    verlag)

Sie dürfen natürlich gerne weitere Konstruktoren definieren, falls Sie diese benötigen. Das Attribut "art",
das in der Klasse Artikel definiert ist, ist für diese Klassen jeweils mit dem Text "Medien" zu belegen.

In der Klasse Artikel und ihren Unterklassen ist eine Methode getBeschreibung wie folgt zu definieren:

String getBeschreibung()
Die zurückzugebende Beschreibung wird je nach Typ anders zusammengesetzt:

- Artikel: art
- Video: titel
- CD: interpret : titel
- Buch: autor : titel

Die Testklasse aus der 5. Übung ist zu erweitern um die Möglichkeit, CD-, Video- und Buch-Objekte erfassen
zu können. Über diese Methode legeAnArtikel() lassen sich im Test nun Objekte vom Typ Artikel, CD,
Video und Buch in das Lager einbuchen.

Zusätzlich ist eine Methode ausgebenBestandsListe() zum Ausgeben der Lagerbestände zu erstellen.

