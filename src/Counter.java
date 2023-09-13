
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Counter {

    private Map<Character, Integer> charCounter =
            new HashMap<Character, Integer>();

    private Map<String, Integer> wordCounter =
            new HashMap<String, Integer>();

    static Counter ct = new Counter();

    public static void main(String[] args) {
        String input = ct.correctString();
        Counter counter = new Counter();
        counter.analyze(input);
        counter.display();
    }

    public void display() {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    public void analyze(String content) {
//        Pattern pattern = Pattern.compile("[\\s\\p{Punct} 0-9]");
        for (char ch : content.toLowerCase().toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);

            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }
    public boolean isValidInput(String input){
        String correcInput = ".*[^\\s\\d\\p{Punct}].";
        Pattern pattern = Pattern.compile(correcInput);
        Matcher mathcher = pattern.matcher(input);
        return  mathcher.matches();
    }

    public String correctString(){
        String input = "";
        while(isValidInput(input)){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter String: ");
            input = sc.nextLine();
            if(!isValidInput(input)){
                System.out.println("Invalid input");
            }
        }
        return input;
    }
}