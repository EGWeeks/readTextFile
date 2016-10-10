
import java.io.FileReader;
import java.util.*;

public class ReadTextFile {

    private String mFilePath;
    private String mFileContents;


    public ReadTextFile(String filePath) {
        mFilePath = filePath;
        mFileContents = readInFile(mFilePath);
    }


    private String readInFile(String filePath){
        try(Scanner scan = new Scanner(new FileReader(filePath))) {
            String fileContents = "";
            while(scan.hasNext()) {
                fileContents += scan.next() + ' ';
            }
            return fileContents;
        } catch(Exception e) {
            System.out.println("Caught Exception: "+e);
            e.printStackTrace();
            return null;
        }
    };


    public Hashtable<String, Integer> wordOccurrence() {

        String[] eachWord = mFileContents.replaceAll("[^a-zA-Z0-9' -]", "").toLowerCase().split(" ");
        Hashtable<String, Integer>wordOccurrence = new Hashtable<>();

        for(String word : eachWord) {
            word = word.toLowerCase();
            if (wordOccurrence.containsKey(word)) {
                int value = wordOccurrence.get(word);
                wordOccurrence.put(word, ++value);
            } else {
                wordOccurrence.put(word, 1);
            }
        }
        return wordOccurrence;
    }


    private ArrayList<String> orderHashOccurrence(Hashtable<String, Integer> wordOccurrence) {

        ArrayList<String> orderedOccurrence = new ArrayList<>();
        String mostOccurred;
        Set<String> set = wordOccurrence.keySet();

        while(set.size() >= 1) {
            mostOccurred = set.iterator().next();
            for(String key : set) {
                int occurrences2 = wordOccurrence.get(key);
                if(wordOccurrence.get(mostOccurred) < occurrences2) {
                    mostOccurred = key;
                }
            }
            orderedOccurrence.add(mostOccurred);
            set.remove(mostOccurred);
        }
        return orderedOccurrence;
    }


    public ArrayList<String> orderOccurrence() {
        Hashtable<String, Integer> wordOccurrence = this.wordOccurrence();
        return this.orderHashOccurrence(wordOccurrence);
    }


    public ArrayList<String> orderOccurrence(Hashtable<String, Integer> wordOccurrence) {
        return this.orderHashOccurrence(wordOccurrence);
    }

}
