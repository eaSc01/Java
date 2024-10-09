import java.util.*;

public class UncommonWordsFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : s1.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : s2.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> uncommon = new ArrayList<>();
        for (String word: wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                uncommon.add(word);
            }
        }

        return uncommon.toArray(new String[0]);
    }
}