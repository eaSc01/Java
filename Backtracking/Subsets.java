package Backtracking;

public class Subsets {
    public static void getSubsets(String src, String ans, int Index) {
        
        if (src.length() == Index) {
            if (ans.length() == 0) {
                System.out.println("NULL");
            } else {
                System.out.println(ans);
            }
            return;
        }

        getSubsets(src, ans+src.charAt(Index), Index+1);    // Yes
        getSubsets(src, ans, Index+1);  // No
    }
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwqyz";
        getSubsets(str, "", 0);
    }
}