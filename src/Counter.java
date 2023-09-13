
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Uyên Nguyễn
 */
public class Counter {
    public final String CHECK = "[^a-zA-Z]";
    private Map<Character, Integer> charCounter =
            new HashMap<Character, Integer>();

    private Map<String, Integer> wordCounter =
            new HashMap<String, Integer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        Counter counter = new Counter();
        counter.analyzeChar(content);
        counter.analyzeWord(content);
        counter.display();
    }

    public void display() {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    public void analyzeChar(String content) {
        for (char ch : content.replaceAll(CHECK," ").toLowerCase().toCharArray()) {
            if (Character.isSpaceChar(ch))
                continue;
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
    }

    public void analyzeWord(String content){
        StringTokenizer tokenizer = new StringTokenizer(content.replaceAll(CHECK," ").toLowerCase());
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }
}