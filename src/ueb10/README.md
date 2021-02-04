# 10. Übung 
Erstellen Sie ein Programm mit der folgenden Funktionalität:

Aufruf: 
```java
java LOCAuswertung _datei1.java datei2.java datei3.java ...._
```

Wirkung: Es werden die sogenannten „Lines of code (LOC)“ gezählt, d. h. die Anzahl an relevanten Codezeilen
in den zu untersuchenden Java-Quelltexten.

Zu beachten ist dabei Folgendes:

- Es ist mindestens eine Datei zu übergeben. Die Gesamtanzahl an übergebenen Dateien ist beliebig.
- Die zu verarbeitenden Dateien sind auf die Eigenschaft "normale Datei" und "Lesbarkeit" zu prüfen.
- Mögliche Ausnahmen sind zu behandeln. Dazu ist eine eigene Ausnahmeklasse zu definieren.
- Bei Lesefehler in einer Datei soll mit der nächsten Datei fortgefahren werden.
- Zu zählen sind dabei alle nichtleeren Zeilen, die keine Kommentarzeilen sind.
    - Dabei können leere Zeilen durchaus eine Länge größer als 0 haben.
    - Als Kommentarzeilen betrachten wir der Einfachheit halber nur die Zeilen, die mit dem String **"//"**
       beginnen.
- Die Ausgabe des Programmes sollte dabei etwa wie folgt aussehen:

Aufruf:
```java
java LOCAuswertung Ausdruck.java Summe.java
```

Ausgabe:

```
Auswertung Lines Of Code (LOC)
Ausdruck.java: 56 LOC
Summe.java: 23 LOC

Gesamt:
2 Dateien 79 LOC
```


