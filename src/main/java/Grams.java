import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Grams {
  private HashMap<String, ArrayList<String>> hashMap = new HashMap<>();;

  public void unigram(String fileName) {
    System.out.println("----- Unigram list -----");
    ngram(1, fileName);
  }

  public void bigram(String fileName) {
    System.out.println("----- Bigram list -----");
    ngram(2, fileName);
  }

  public void trigram(String fileName) {
    System.out.println("----- Trigram list -----");
    ngram(3, fileName);
  }

  public void ngram(int n, String fileName) {

    if(n > 3) {
      System.out.println("----- " + n + "-gram list -----");
    }

    try {
      File file = new File(fileName);
      FileReader fileReader = new FileReader(file);
      BufferedReader br = new BufferedReader(fileReader);
      String line;
      ArrayList<String> arrayList = new ArrayList<>();

      while((line = br.readLine()) != null) {
        int size = line.length();

        for(int i = 0; i + n < size; i++) {
          arrayList.add(line.substring(i, i + n));
        }

        hashMap.put(String.valueOf(hashMap.size() + 1).toString(), arrayList);
      }

      arrayList.forEach(l -> {
        System.out.println(l);
      });

    } catch(FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }

    System.out.println("------------------------");
  }

  public void resultMap(String way) {
    System.out.println("----- result -----");

    if(way == "ambiguous") {
      searchWay("ambiguous");
    } else {
      searchWay("noambiguous");
    }

    System.out.println("------------------------");
  }

  private void searchWay(String way) {
    switch(way) {
      case "ambiguous":
      for(String key : hashMap.keySet()) {
        System.out.println("[Result" + key + "] " + hashMap.get(key) + "\n");
        System.out.println("");
      }

      break;

      case "noambiguous":
      for(String key : hashMap.keySet()) {
        System.out.println("[Result" + key + "] " + hashMap.get(key) + "\n");

        System.out.println("  --- result columns ---");

        for(int i = 0; i < hashMap.get(key).size(); i++) {
          System.out.println("  " + key + ":" + i + " " + hashMap.get(key).get(i));
        };

        System.out.println("");
      }

      break;
    }
  }
}
