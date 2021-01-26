package ueb09;

public class PersonQueue implements Queue {

  private final Person[] persons;

  public PersonQueue(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Warteschlange muss größer als 0 sein");
    }
    this.persons = new Person[size];
  }

  public PersonQueue() {
    this(10);
  }

  @Override
  public void addLast(Object o) {
    if (!(o instanceof Person)) {
      throw new ClassCastException(
          String.format("%s is not of type Person", o.getClass().getName()));
    }
    if (full()) {
      throw new IllegalArgumentException("Warteschlange ist voll");
    }
    persons[size()] = (Person) o;
  }

  @Override
  public Person removeFirst() {
    if (empty()) {
      throw new IllegalArgumentException("Warteschlange ist leer");
    }
    Person firstPerson = persons[0];
    int index = 0;
    for (int i = index; i < persons.length - 1; i++) {
      if (persons[i] != null) {
        persons[i] = persons[i + 1];
      }
    }
    persons[persons.length - 1] = null;
    return firstPerson;
  }

  @Override
  public Person get(int i) {
    return persons[i];
  }

  @Override
  public boolean empty() {
    return persons[0] == null;
  }

  @Override
  public boolean full() {
    return persons[persons.length - 1] != null;
  }

  @Override
  public int size() {
    int count = 0;
    for (Person person : persons) {
      if (person != null) {
        count++;
      }
    }
    return count;
  }
}
