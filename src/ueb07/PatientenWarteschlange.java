package ueb07;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PatientenWarteschlange {

    private Patient[] warteliste;

    public PatientenWarteschlange(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Warteschlange muss größer als 0 sein");
        }
        warteliste = new Patient[size];
    }

    public void neuerPatient(int number, String name) {
        if (isFull()) {
            throw new IllegalArgumentException("Warteschlange ist voll");
        }
        if (getPatientByNr(number) != null) {
            throw new IllegalArgumentException(
                    String.format("Der Patient mit der Nummer %d existiert bereits in der Warteschlange", number));
        }
        warteliste[getPatientenAnzahl()] = new Patient(number, name);
    }

    public Patient entfernePatient(int number) {
        for (int i = 0; i < warteliste.length; i++) {
            if (warteliste[i] != null && warteliste[i].getNumber() == number) {
                Patient patient = warteliste[i];
                warteliste[i] = warteliste[getPatientenAnzahl() - 1];
                warteliste[getPatientenAnzahl() - 1] = null;
                return patient;
            }
        }
        throw new NoSuchElementException(String.format("Der Patient mit der Nummer %d existiert nicht", number));
    }

    public Patient derNaechsteBitte() {
        Patient patient = warteliste[0];
        if(patient == null){
            return null;
        }
        entfernePatient(patient.getNumber());
        return patient;
    }

    public Patient getPatientByNr(int number) {
        for (Patient patient : warteliste) {
            if (patient != null && patient.getNumber() == number) {
                return patient;
            }
        }
        return null;
    }

    public int getPatientenAnzahl() {
        return (int) Arrays.asList(warteliste).stream().filter(artikel -> artikel != null).count();
    }

    public int getWarteschlagenGroesse() {
        return warteliste.length;
    }

    public boolean isFull() {
        return !((getPatientenAnzahl()) < getWarteschlagenGroesse());
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Warteliste\nPnr     Name\n");
        Arrays.asList(warteliste).stream().filter(patient -> patient != null)
                .forEach(patient -> stringBuilder.append(patient.getNumber() + "    " + patient.getName() + "\n"));
        return stringBuilder.toString();
    }
}
