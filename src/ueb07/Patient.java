package ueb07;

public class Patient {

  private final int number;
  private String name;
  private static final int MIN = 1000;
  private static final int MAX = 9999;

  /**
   * Konstruktor für den Patient Überprüft, ob die ID vierstellig ist.
   *
   * @param number die Nummer des Patienten
   * @param name der Name des Patienten
   */
  public Patient(int number, String name) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException("Die Patientennummer muss vierstellig sein");
    }
    this.number = number;
    setName(name);
  }

  public int getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty() || name.split(" ").length < 2) {
      throw new IllegalArgumentException(
          "Der Name darf nicht leer sein und muss aus mindestens zwei Teilen bestehen");
    }
    this.name = name;
  }

  @Override
  public String toString() {
    return number + " " + name;
  }
}
