public class RunLengthEncoding {
    public static void main(String[] args) {
        String s = "aaawwefffffnnnnnttudddd";
        String rle = getRle(s);
        System.out.println(rle);
    }

    private static String getRle(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i<s.length(); i++) {
            count++;

            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(count).append(s.charAt(i));
                count = 0;
            }
        }
        
        return sb.toString();
    }
}
