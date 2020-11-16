**1. Übung zu Programmierung 1**

Entwerfen Sie eine Klasse Artikel für eine einfache Bestandsführung mit den folgenden
Eigenschaften:

Es werden Attribute (in Klammern die zu verwendenden Attributnamen) benötigt für:

- Artikelnummer (artikelNr)
- Artikelart (art)
- aktueller Artikelbestand in Stück (bestand)

Es werden mindestens die folgenden Methoden benötigt:

- void bucheZugang(int menge)
    buche einen Zugang, d. h. erhöhe den Bestand um eine bestimmte Menge
- void bucheAbgang(int menge)
    buche einen Abgang, d. h. vermindere den Bestand um eine bestimmte Menge
- String toString()
    eine toString-Methode, um ein Artikel-Objekt als Zeichenkette aufbereiten zu können
Beispiel:
Artikel: 4711 Bezeichnung: Staubsauger Bestand: 100
- get-Methoden zu allen Attributen
- set-Methoden nur zu den Attributen, für die eine set-Methode Sinn macht.

Konstruktoren:

- Artikel(int artikelNr, String art, int bestand)
    Artikel(int artikelNr, String art)
    konstruiere ein Artikel-Objekt mit Hilfe der übergebenen Werte
- Warum macht ein Standardkonstruktor keinen Sinn?

Folgende Bedingungen sind noch optional, aber ab der Folgeübung zu beachten:

- Die Artikelnummer muss eine 4-stellige positive Zahl sein.
- Die Bezeichnung darf nicht null sein.
- Der Bestand darf nie kleiner als 0 werden.
- Die beim Buchen von Ab- und Zugängen übergebenen Werte müssen auf > 0 überprüft werden.

Vorgehensweise:

- Erstellen Sie die Klasse mit dem Entwicklungswerkzeug BlueJ.
- Zu einem professionellen Quellcode gehören natürlich sinnvolle Kommentierungen, eine
    selbsterklärende Namensgebung für Attribute, Variablen und Konstanten, sowie eine
    Strukturierung des Programmtextes.
- Testen Sie ihre Klasse, indem sie Objekte in BlueJ erzeugen und deren Schnittstelle bedienen.

Bemerkung:
Die vorgegebenen Namen und Signaturen für die Klasse, die Konstruktoren und die Methoden sind
**unbedingt** einzuhalten, damit Ihre Lösung automatisch auf Korrektheit überprüft werden kann!


