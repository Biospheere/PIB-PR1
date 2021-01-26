package ueb09;

public class Person {

  private final String first_name;
  private String last_name;

  public Person(String first_name, String last_name) {
    this.first_name = first_name;
    this.last_name = last_name;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  @Override
  public String toString() {
    return String.format("%s %s", first_name, last_name);
  }
}
