import java.util.ArrayList;
import java.util.List;

public class FithExecercise {

    public static void main(String... args) {
        try {
            Playlist p = new Playlist("Favoriten", 20);
            Aufnahme a1 = new Aufnahme("Stairway To Heaven", "Led Zeppelin", 1971);
            Aufnahme a2 = new Aufnahme("Child in Time", "Deep Purple", 1970);
            Aufnahme a3 = new Aufnahme("Rain", "Uriah Heep", 1972);
            Aufnahme a4 = new Aufnahme("Bohemian Rhapsody", "Queen", 1975);

            p.add(a1);
            p.add(a2);
            p.add(a3);
            if(!p.isFull()){
                p.add(a4);
            }
            p.remove("Rain");
            System.out.println(p);
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static class Playlist {

        private final String name;
        private final int maxTitle;
        private final List<Aufnahme> playlist;

        /**
         * @param name
         * @param maxTitle
         */
        public Playlist(String name, int maxTitle) {
            if (name.isBlank() || name == null) {
                throw new IllegalArgumentException("Name darf nicht leer sein");
            }
            if (maxTitle > 20) {
                throw new IllegalArgumentException("Es sind maximal 20 Titel erlaubt");
            }
            if (maxTitle < 1) {
                throw new IllegalArgumentException("Es muss mindestens 1 Titel erlaubt sein");
            }
            this.name = name;
            this.maxTitle = maxTitle;
            playlist = new ArrayList<>();
        }

        public void add(Aufnahme aufnahme){
            if(isFull()){
                throw new IllegalStateException("Playlist ist bereits voll");
            }
            playlist.add(aufnahme);
        }

        public void remove(String title){
            for(Aufnahme aufnahme : playlist){
                if(aufnahme.getTitle().equalsIgnoreCase(title)){
                    playlist.remove(aufnahme);
                    break;
                }
            }
        }

        public boolean isFull(){
            return !((playlist.size()) < maxTitle);
        }

        @Override
        public String toString() {
            final String title = "Playlist: " + name;
            String table = "\nNr Title Interpret Jahr\n";
            for (int i = 0; i < playlist.size(); i++) {
                final Aufnahme aufnahme = playlist.get(i);
                table += String.format("%d: %s %s %d\n", i + 1, aufnahme.getTitle(), aufnahme.getInterpret(),
                        aufnahme.getYear());
            }
            return title + table;
        }

    }

    public static class Aufnahme {

        private final String title;
        private final String interpret;
        private final int year;

        /**
         * @param title
         * @param interpret
         * @param year
         */
        public Aufnahme(String title, String interpret, int year) {
            if (title.isBlank() || title == null) {
                throw new IllegalArgumentException("Titel darf nicht leer sein");
            }
            if (interpret.isBlank() || interpret == null) {
                throw new IllegalArgumentException("Interpret darf nicht leer sein");
            }
            if (!(year >= 1950) && !(year <= 2019)) {
                throw new IllegalArgumentException("Jahr darf nur zwischen 1950 und 2019 liegen");
            }
            this.title = title.trim();
            this.interpret = interpret;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public String getInterpret() {
            return interpret;
        }

        public int getYear() {
            return year;
        }

    }

}
