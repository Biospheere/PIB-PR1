**3. Übung zu Programmierung 1**


Entwickeln sie eine Klasse MathFunctions, die ähnlich wie die Klasse java.lang.Math Funktionen in
Form von Klassenmethoden anbietet und eine Dialogklasse zum interaktiven Testen dieser Klasse.

Vorläufig anzubietende Funktionen:

(1) static long berechneTeilersumme (long zahl)
Teilersumme zu einer übergebenen natürlichen Zahl berechnen und zurückgeben.
(2) static String berechneChecksummeIsbn(long isbn)
Prüfziffer für eine ISBN-10 berechnen

**Zu (1): Teilersumme:**

Hier ist die Summe der Teiler einer natürlichen Zahl zu ermitteln. Beispielsweise gilt:

teilersumme(6) = 1 + 2 + 3 + 6 = 12

**Zu (2): ISBN-10**

Die Internationale Standardbuchnummer, abgekürzt ISBN, ist eine Nummer zur eindeutigen
Kennzeichnung von Büchern und anderen Veröffentlichungen mit redaktionellem Anteil. Es gibt die
ältere ISBN-10, bestehend aus 10 Ziffern und die neuere ISBN-13, bestehend aus genau 13 Ziffern. Die
letzte Ziffer ist dabei eine sogenannte Prüfziffer, die aus den ersten 9 bzw. 12 Ziffern berechnet werden
kann.
Die Prüfziffer zu einer ISBN-10 wird wie folgt berechnet: Bezeichnet man die ersten neun Ziffern mit z 1
bis z 9 , so gilt für die Prüfziffer an der zehnten Stelle:

Ergibt sich als Ergebnis der Wert 10, so wird als Prüfziffer das Zeichen X verwendet.

_Beispiele:_

386680192 -? z 10 = 1⋅3 + 2⋅8 + 3⋅6 + 4⋅6 + 5⋅8 + 6⋅0 + 7⋅1 + 8⋅9 + 9⋅2 = 198 = 0 mod 11

383622862 -? z 10 = 1⋅3 + 2⋅8 + 3⋅ 3 + 4⋅6 + 5⋅ 2 + 6⋅ 2 + 7⋅ 8 + 8⋅ 6 + 9⋅2 = 196 = 9 mod 11

Übergeben Sie der Methode die zu prüfende Zahl als long-Zahl und geben Sie die errechnete
Prüfziffer als String zurück.



