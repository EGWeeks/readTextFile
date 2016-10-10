
import java.util.Hashtable;

class Test {
    public static void main(String[] args) {

        ReadTextFile readMe = new ReadTextFile("./README.md");

        Hashtable<String, Integer> stuff = readMe.wordOccurrence();

        System.out.println(readMe.orderOccurrence(stuff));

    }
}