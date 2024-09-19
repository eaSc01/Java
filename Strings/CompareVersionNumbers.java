class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        for (int i = 0; i<Math.max(s1.length, s2.length); i++) {
            int r1 = Integer.parseInt((i < s1.length) ? s1[i] : "0");
            int r2 = Integer.parseInt((i < s2.length) ? s2[i] : "0");

            if (r1 > r2) {
                return 1;
            } else if (r1 < r2) {
                return -1;
            }
        }

        return 0;
    }
}