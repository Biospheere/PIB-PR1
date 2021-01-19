package ueb07;

import java.util.NoSuchElementException;

public class PatientenWarteschlange {

  private Patient[] warteliste;

  /**
   * Konstruktor Warteschlange Überprüft, ob die eingegebene Größe >= 0 ist
   *
   * @param size Maximale Größe der zu erstellenden Wartechlanger
   */
  public PatientenWarteschlange(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Warteschlange muss größer als 0 sein");
    }
    warteliste = new Patient[size];
  }

  /**
   * Erstellt einen neuen Patienten Überprüft, ob die Warteschlange voll ist oder der Patient
   * bereits existiert
   *
   * @throws IllegalArgumentException Wenn Warteschlange voll ist
   * @throws IllegalArgumentException Wenn der Patient bereits existiert
   * @param number ID des zu erstellenden Patienten
   * @param name Name des zu erstellenden Patienten
   */
  public void neuerPatient(int number, String name) {
    if (isFull()) {
      throw new IllegalArgumentException("Warteschlange ist voll");
    }
    if (getPatientByNr(number) != null) {
      throw new IllegalArgumentException(
          String.format(
              "Der Patient mit der Nummer %d existiert bereits in der Warteschlange", number));
    }
    warteliste[getPatientenAnzahl()] = new Patient(number, name);
  }

  /**
   * Entfernt einen bestehenden Patienten aus der Warteschlange
   *
   * @throws NoSuchElementException Wenn die übergebene ID nicht existiert
   * @param number die Patientennummer
   * @return patient
   */
  public Patient entfernePatient(int number) {
    int index = getIndexByNr(number);
    if (index == -1) {
      throw new NoSuchElementException(
          String.format("Der Patient mit der Nummer %d existiert nicht", number));
    }
    Patient patient = getPatientByNr(number);
    for (int i = index; i < warteliste.length - 1; i++) {
      if (warteliste[i] != null) {
        warteliste[i] = warteliste[i + 1];
      }
    }
    warteliste[warteliste.length - 1] = null;
    if (getPatientenAnzahl() == 0) {
      System.out.println("Die Warteschlange ist jetzt leer");
    }
    return patient;
  }

  /**
   * Übergibt den Patienten, der als nächstes dran genommen werden soll
   *
   * @throws NoSuchElementException Wenn die Warteschlange leer ist
   * @return der Patient der gerade aufgerufen wurde
   */
  public Patient derNaechsteBitte() {
    final Patient patient = warteliste[0];
    if (patient == null) {
      throw new NoSuchElementException("Es existiert kein Patient mehr in der Warteschlange");
    }
    entfernePatient(patient.getNumber());
    return patient;
  }

  /**
   * Sucht anhand der übergebenen ID den Patienten in der Warteschlange
   *
   * @param number ID eines Patienten
   * @return patient oder null
   */
  public Patient getPatientByNr(int number) {
    for (Patient patient : warteliste) {
      if (patient != null && patient.getNumber() == number) {
        return patient;
      }
    }
    return null;
  }

  /**
   * Ermittelt den Index im Array anhand einer überge
   *
   * @param number
   * @return i oder -1
   */
  public int getIndexByNr(int number) {
    for (int i = 0; i < warteliste.length; i++) {
      if (warteliste[i] != null && warteliste[i].getNumber() == number) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Ermittelt die Anzahl an Patienten in der Warteschlange
   *
   * @return count
   */
  public int getPatientenAnzahl() {
    int count = 0;
    for (Patient patient : warteliste) {
      if (patient != null) {
        count++;
      }
    }
    return count;
  }

  /**
   * Übergibt die maximale Größe der Warteschlange
   *
   * @return warteliste.length
   */
  public int getWarteschlagenGroesse() {
    return warteliste.length;
  }

  /** @return Ob die Warteschlange voll ist */
  public boolean isFull() {
    return !((getPatientenAnzahl()) < getWarteschlagenGroesse());
  }

  /** Gibt die ganze Warteschlange aus */
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Warteliste\n Pnr Name\n");
    for (Patient patient : warteliste) {
      if (patient != null) {
        stringBuilder.append(patient + "\n");
      }
    }
    return stringBuilder.toString();
  }
}
