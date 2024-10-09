public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i< n; i++) {
            s = rle(s);
        }
        return s;
    }

    public String rle(String s) {
        StringBuilder sb = new StringBuilder("");
        int count = 1;

        for (int i = 1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;

            } else {
                sb.append(String.valueOf(count));
                sb.append(s.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(String.valueOf(count));
        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }
}