import java.util.*;

public class LongestSubstringVowelsEvenCounts {
    public int findTheLongestSubstring(String s) {
        int xor = 0, len = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u') {
                xor = xor ^ c;
            }

            if (map.containsKey(xor)) {
                len = Math.max(len, i - map.get(xor));
            } else {
                map.put(xor, i);
            }
        }

        return len;
    }
}