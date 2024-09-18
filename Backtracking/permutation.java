public class Permutation {
    public static void permutate(String src, String ans) {

        if (src.length() == 0) {
            // System.out.println();
            System.out.println("Final: " + ans);
            return;
        }

        for (int i=0 ; i<src.length() ; i++) {
            char curr = src.charAt(i);
            String newSrc = src.substring(0, i) + src.substring(i+1);
            // System.out.println("SRC: " + src);
            // System.out.println("ANS: " + ans);
            permutate(newSrc, ans + curr);
        }
    }
    public static void main(String[] args) {
        String source = "abc";
        permutate(source, "");
    }
}
