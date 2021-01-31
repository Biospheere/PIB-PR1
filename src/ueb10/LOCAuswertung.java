package ueb10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LOCAuswertung {

    public static long countLOC(File file) {
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            return stream.filter(line -> !line.trim().startsWith("//") && !line.isBlank()).count();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String... args) throws IOException {
        if(args.length == 0){
            System.out.println("java LOCAuswertung datei1.java datei2.java datei3.java ....");
            return;
        }
        System.out.println("Auswertung Lines Of Code (LOC)");
        long sumLOC = 0;
        long sumFiles = 0;
        for (String fileName : args) {
            final File file = new File(fileName);
            if (!file.exists() || !file.canRead() || !fileName.endsWith(".java")) {
                continue;
            }
            final long count = countLOC(file);
            System.out.printf("%s: LOC %d\n", fileName, count);
            sumLOC += count;
            sumFiles++;
        }
        System.out.printf("Gesamt: \n%d Dateien %d LOC", sumFiles, sumLOC);
    }

}
