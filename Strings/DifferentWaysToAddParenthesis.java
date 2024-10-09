import java.util.*;

public class DifferentWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i<expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '*' || c == '+' || c == '-') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftAns = diffWaysToCompute(left);
                List<Integer> rightAns = diffWaysToCompute(right);

                for (int a: leftAns) {
                    for (int b: rightAns) {
                        if (c == '*') {
                            ans.add(a * b);
                        } else if (c == '+') {
                            ans.add(a + b);
                        } else {
                            ans.add(a - b);
                        }
                    }
                }
            }
        }

        if (ans.size() == 0) {
            ans.add(Integer.parseInt(expression));
        }

        return ans;
    }
}