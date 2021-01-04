```
Es existieren zwei Implentierungen für die Lager Klasse.
Einmal mit einem Array und einmal mit einer ArrayList.
Der Rückgabewert bei getArtikel ist ein Optional anstatt Artikel!
```

**5. Übung zu Programmierung**
**1. Aufgabe**

Erstellen Sie ergänzend zur 1. und 2. Übung eine Klasse Lager zum Verwalten von mehreren Artikeln.

Es sollte wenigstens die folgenden Konstruktoren bei Lager geben:

- ein Konstruktor, der als Parameter einen int-Wert für die Dimension des zu erzeugenden Artikel- Arrays erhält
- ein Standard-Konstruktor, der die vorgegebene Maximalgröße 10 für das Artikel-Array verwendet

Folgende Methoden werden benötigt:

- void legeAnArtikel(Artikel artikel)
  
  ```
  Ein vorher angelegtes Artikel-Objekt in das Artikel-Array des Lagers einfügen. Eine Sortierung ist vorerst nicht erforderlich.
  ```

- void entferneArtikel(int artikelNr)
  ```
  Entfernen eines Artikels aus dem Lager, d. h. das Artikel-Objekt ist aus dem Artikel-Array so zu löschen, dass keine Lücke entsteht.
  ```
- void bucheZugang(int artikelNr, int menge)
  ```
  Zugang buchen für einen Artikel
  ```
- void bucheAbgang(int artikelNr, int menge)
  ```
  Abgang buchen für einen Artikel
  ```
- void aenderePreisAllerArtikel(double prozent)
  ```
  Preis für alle Artikel um einen bestimmten Prozentsatz verändern (positiv oder negativ möglich)
  ```
- Artikel getArtikel(int index)
  ```
  Ermittelt einen Artikel an einer bestimmten Stelle im Lager
- Die Klasse Artikel ist dafür um ein Attribut preis (muss > 0 sein!) zu erweitern. Ggf. sind dafür ein Konstruktor, sowie eine set- und eine get-Methode zu ergänzen
- String toString()
- Mindestens get-Methoden für:
    ```
    int getArtikelAnzahl() - Die aktuelle Anzahl der Artikel im Lager
    int getLagerGroesse() - Die Anzahl der Artikel, die ins Lager gelegt werden können
    ```

Überlegen Sie sich, welche Attribute Sie benötigen und welche Prüfungen in der Lager-Klasse erforderlich sind. Natürlich dürfen Sie weitere Hilfsmethoden und Getter und Setter in Ihre Klassen einbauen.

**2. Aufgabe**

Erstellen Sie eine Dialog-Klasse zum Testen der Klasse Lager. Die Klasse soll analog zur Testklasse zur Klasse Artikel aufgebaut sein.

**3. Aufgabe (freiwilliger Zusatz)**

Versuchen Sie sich an weitgehend vollständigen JUnit-Testklassen für die Klassen Artikel und Lager.
Die dazu notwendigen Techniken werden noch besprochen.


