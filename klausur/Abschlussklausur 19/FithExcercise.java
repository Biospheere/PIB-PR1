import java.util.HashMap;
import java.util.Map;

public class FithExcercise {

    public static void main(String... args) {
        try {
            AktenOrdner ordner = new AktenOrdner("Praktische Informatik");
            Akte akte1 = new Akte(1234, "ASPO-Anlage", "Version 2017");
            Akte akte2 = new Akte(4711, "Wahlpflichtmodule", "Sommersemester 2020");
            Akte akte3 = new Akte(3333, "Reakkredtierungen", "Version 2017");
            if (akte1.equals(akte2)) {
                System.out.println("Die Akten sind identisch");
            }

            ordner.fuegeEinAkte(akte1);
            ordner.fuegeEinAkte(akte2);
            ordner.fuegeEinAkte(akte3);
            System.out.println(ordner);

            ordner.aendereInhalt(1234, "Version 2020");
            ordner.entferneAkte(3333);
            System.out.println(ordner);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static class AktenOrdner {

        private final String bezeichnung;
        private final Map<Integer, Akte> ordner;

        public AktenOrdner(String bezeichnung) {
            if (bezeichnung.isBlank() || bezeichnung == null) {
                throw new IllegalArgumentException("Bezeichnung darf nicht leer sein");
            }
            this.bezeichnung = bezeichnung;
            ordner = new HashMap<>();
        }

        public void fuegeEinAkte(Akte akte) {
            if (ordner.containsKey(akte.getZeichen())) {
                throw new IllegalStateException("Eine Akte mit diesem Zeichen existiert bereits");
            }
            ordner.put(akte.getZeichen(), akte);
        }

        public void aendereInhalt(int zeichen, String inhalt) {
            if (!ordner.containsKey(zeichen)) {
                throw new IllegalStateException("Akte existiert nicht");
            }
            ordner.get(zeichen).setInhalt(inhalt);
        }

        public void entferneAkte(int zeichen) {
            ordner.remove(zeichen);
        }

        @Override
        public String toString() {
            String result = "Aktenordner: " + bezeichnung + "\nAnzahl Akten: " + ordner.size() + "\n";
            for (Map.Entry<Integer, Akte> entry : ordner.entrySet()) {
                result += String.format("%d     %s     %s\n", entry.getKey(), entry.getValue().getBezeichnung(),
                        entry.getValue().getInhalt());
            }
            return result;
        }

    }

    public static class Akte {

        private final int zeichen;
        private final String bezeichnung;
        private String inhalt;

        public Akte(int zeichen, String bezeichnung, String inhalt) {
            if (zeichen < 0) {
                throw new IllegalArgumentException("Aktenzeichen muss größer als 0 sein");
            }
            if (bezeichnung.isBlank() || bezeichnung == null) {
                throw new IllegalArgumentException("Bezeichnung darf nicht leer sein");
            }
            if (inhalt.isBlank() || inhalt == null) {
                throw new IllegalArgumentException("INhalt darf nicht leer sein");
            }
            this.zeichen = zeichen;
            this.bezeichnung = bezeichnung;
            this.inhalt = inhalt;
        }

        public int getZeichen() {
            return zeichen;
        }

        public String getBezeichnung() {
            return bezeichnung;
        }

        public String getInhalt() {
            return inhalt;
        }

        public void setInhalt(String inhalt) {
            this.inhalt = inhalt;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            final Akte akte = (Akte) obj;
            return this.zeichen == akte.getZeichen() && this.bezeichnung == akte.getBezeichnung()
                    && this.inhalt == akte.getInhalt();
        }

    }

}
