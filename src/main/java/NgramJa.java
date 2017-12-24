import java.io.File;

public class NgramJa {
  public static void main(String... args) {
    Grams grams = new Grams();
    String[] files = new File("./reference").list();

    for(String file : files) {
      grams.bigram("./reference/" + file);
    }

    grams.resultMap("noambiguous");
  }
}
