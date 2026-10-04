import java.util.*;

public class ex4 {
    public static void main(String[] args) {
        String text = "Hello world! Hello again. Welcome to the Java world.";
        System.out.println( text);
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = cleanText.split("\\s+");
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Частота встречаемости: ");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println("Слово '" + entry.getKey() + "' встречается: " + entry.getValue() + " раз(а)");
        }
    }
}
