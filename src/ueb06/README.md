# 6. Übung zu Programmierung**

Schreiben Sie ein Java-Programm, das aus HTML-Dateien die Hypertextlinks herausfiltert und ausgibt.
Da wir noch keine Dateiverarbeitung besprochen haben, ist es am einfachsten, diese Dateien über
java.util.Scanner einzulesen. Übergeben Sie dazu den Namen der zu lesenden Datei über die
Kommandozeile oder in BlueJ als Parameter der main-Methode.

Start des Programms in der Shell:

```bash
java LinkFilter test1.html
```

Die Datei kann dann wie folgt geöffnet werden:

```java
Scanner input = new Scanner(new File(args[0]));
```

Danach kann die Datei ganz normal gelesen werden wie bisher die Standardeingabe. Die
Hypertextlinks werden durch das a-Element definiert (siehe dazu auch
https://wiki.selfhtml.org/wiki/HTML/Textauszeichnung/a)

Wenn die HTML-Datei z. B. wie folgt aussieht:

test1.html:
```html
.
<li> **<a href** ="http://www.htwsaar.de/" **>** Hochschule für Technik und Wirtschaft **</a>**
.
<li> **<a href** ="http://www.google.com" **>** Google **</a>
<a href** ="http://www.heise.de">Heise Online **</a>**
.
```

Dann sollte die Ausgabe in etwa so aussehen:

- Hochschule für Technik und Wirtschaft: [http://www.htwsaar.de](http://www.htwsaar.de)

- Google: [http://www.google.com](http://www.google.com)

- Heise Online: [http://www.heise.de](http://www.heise.de)


