package ueb06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFilter {

  private static final Pattern PATTERN =
      Pattern.compile(
          "<a[^>]+href=[\\\"'](.+?)[\\\"'>]+[\\\"']?[^>]*>(.+?)<\\/a>",
          Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

  /**
   * Filter <code>input</code> for hyperlink a tags
   *
   * @param input the text to filter
   */
  public static void filterLinks(String input) {
    final Matcher pageMatcher = PATTERN.matcher(input);
    while (pageMatcher.find()) {
      System.out.println(pageMatcher.group(1) + ":" + pageMatcher.group(2));
    }
  }

  /**
   * @param filename the path to the file
   * @return the content of the file
   */
  public static String getFileContent(String filename) {
    final File file = new File(filename);
    if (file.exists()) {
      try {
        return Files.readString(Paths.get(file.getAbsolutePath()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /** @param args the files to filter */
  public static void main(String... args) {
    Arrays.asList(args).stream()
        .map(m -> getFileContent(m))
        .filter(input -> input != null)
        .forEach(input -> filterLinks(input));
  }
}
