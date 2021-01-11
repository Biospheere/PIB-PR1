package ueb07;

public class Patient {

    private final int number;
    private final String name;

    /**
     * @param number
     * @param name
     */
    public Patient(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + " " + name;
    }
    
    
    
}
