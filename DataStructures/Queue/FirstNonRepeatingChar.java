import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class FirstNonRepeatingChar {

    public static List<Character> solution(String string) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        List<Character> ans = new ArrayList<>();
        
        for (int i = 0; i<string.length(); i++) {
            char c = string.charAt(i);

            freq[c - 'a']++;
            q.offer(c);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                System.out.println("-");
                ans.add('-');
            } else {
                ans.add(q.peek());
                System.out.println(q.peek());
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        solution("aabccxb");
    }
}
