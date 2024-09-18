package Stacks;
import java.util.Stack;

class SolutionBruteForce {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] pse = calcPSE(heights);
        int[] nse = calcNSE(heights);

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public int[] calcPSE(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] pse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!stk.empty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if (stk.empty()) {
                pse[i] = -1;
            } else {
                pse[i] = stk.peek();
            }

            stk.push(i);
        }

        return pse;
    }

    public int[] calcNSE(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] nse = new int[arr.length];

        for (int i = arr.length - 1; i>= 0; i--) {
            while (!stk.empty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if (stk.empty()) {
                nse[i] = arr.length;
            } else {
                nse[i] = stk.peek();
            }

            stk.push(i);
        }

        return nse;
    }
}


class SolutionOptimal {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stk.empty() && heights[stk.peek()] > heights[i]) {
                int element = stk.pop();
                int nse = i;
                int pse = stk.empty() ? -1 : stk.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }

            stk.push(i);
        }

        while (!stk.empty()) {
            int nse = heights.length;
            int element = stk.pop();
            int pse = stk.empty() ? -1 : stk.peek();

            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }

        return maxArea;
    }
}