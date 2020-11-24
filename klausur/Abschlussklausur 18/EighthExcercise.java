import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EighthExcercise {

    public static void main(String... args) {
        if(args.length < 1){
            System.out.print("Du musst eine Datei als Argument angeben");
            return;
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Die Datei " + args[0] + " existiert nicht");
            return;
        }
        try (final Scanner scanner = new Scanner(new FileReader(file))) {
            int matches = 0;
            int score = 0;
            int bestScore = 0;
            String bestPlayer = null;
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().replaceAll("\\s+", " ").split(" ");
                score += Integer.valueOf(line[1]);
                matches++;
                if(bestPlayer == null){
                    bestPlayer = line[0];
                    bestScore = score;
                } else if(Integer.valueOf(line[1]) > bestScore){
                    bestPlayer = line[0];
                    bestScore = Integer.valueOf(line[1]);
                }
            }
            System.out.println("Datei: " + args[0]);
            System.out.println("Spiele ingesamt: " + matches);
            if(bestPlayer != null){
                System.out.println("Highscore: " + bestPlayer + ": " + bestScore);
            }
            System.out.println("Durchschnittlicher Score: " + (double)(score / matches));

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

}
