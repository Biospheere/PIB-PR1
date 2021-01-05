package ueb06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
  public void filterLinks(String input) {
    final Matcher pageMatcher = PATTERN.matcher(input);
    while (pageMatcher.find()) {
      System.out.println(pageMatcher.group(1) + ":" + pageMatcher.group(2));
    }
  }

  /** @param args the files to filter */
  public static void main(String... args) {
    final LinkFilter linkFilter = new LinkFilter();
    for (String filename : args) {
      final File file = new File(filename);
      if (file.exists()) {
        try {
          linkFilter.filterLinks(Files.readString(Paths.get(file.getAbsolutePath())));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
