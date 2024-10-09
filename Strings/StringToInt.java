public class StringToInt {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        
        int value = 0;
        int i = 0;
        boolean isNegative = false;

        if (s.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        for (; i<s.length(); i++) {
            char c = s.charAt(i);
            int num = c - '0';

            if (num > 9 || num < 0) {
                break;
            }

            if (value > (Integer.MAX_VALUE - num)/10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            value = (value * 10) + num;
        }

        return isNegative ? -value : value;
    }
}