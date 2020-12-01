import java.io.File;

public class EighthExcercise {

    public static void main(String... args) {
        if(args.length < 2){
            System.out.println("Bitte gebe einen Suchstring und ein Verzeichnis an");
            return;
        }
        String searchString = args[0];
        File file = new File(args[1]);
        if(file.exists() && !file.isDirectory()){
            System.out.println("Das Verzeichnis existiert nicht oder ist eine Datei");
            return;
        }
        for(File files : file.listFiles()){
            if(file.canRead() && files.getName().contains(searchString)){
                System.out.println(files.getName());
            }
        }
    }

}
