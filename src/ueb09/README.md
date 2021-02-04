# 9. Übung 

Durch das folgende Interface wird eine Schnittstelle für eine sehr einfache Implementierung einer
Warteschlangen-Klasse vorgegeben:

```java
public interface Queue {
  // Objekt hinten anfuegen
  void addLast(Object o);

  // Entferne das erste Element und gebe eine Referenz darauf zurueck
  Object removeFirst();

  // Das i-te Element zurueckgeben
  Object get(int i);

  // Testen, ob schon Elemente eingefuegt wurden
  boolean empty();

  // Testen, ob noch Elemente einfuegbar sind, d. h. ob das letzte Element schon einen Wert != null
  // hat
  boolean full();

  // Anzahl eingefuegter Elemente
  int size();
}
```

Implementieren Sie eine Klasse StringQueue und eine Klasse PersonQueue, die das Interface Queue jeweils
implementieren. Bei der Methode addLast ist darauf zu achten, dass tatsächlich jeweils nur Objekte vom
Typ String bzw. Person angefügt werden können.

Erstellen Sie ein interaktives Testprogramm zum Testen der Methoden addLast und removeFirst, das
möglichst unabhängig von den Klassen StringQueue und PersonQueue sein sollte. Insbesondere sollten Sie
die Ausgabe einer Queue mit Hilfe einer Methode

```java
void print(Queue q)
```

realisieren, die die jeweilige Warteschlange mit Hilfe der get-Methode sequenziell durchläuft und ausgibt.

Bemerkungen:

- Die Implementierung kann mit Arrays einer vorgegebenen Größe erfolgen.
- Es wird ein Konstruktor benötigt, dem als Parameter die Größe des Implementierungsarrays übergeben
    wird.
- Verwenden Sie Ausnahmebehandlung, um zu verhindern, dass Arraygrenzen überschritten werden.
- Die Klasse Person aus der Vorlesung kann natürlich verwendet werden.


