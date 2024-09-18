package Stacks;
import java.util.Stack;

public class Questions {

    public static String reverseString(String str) {
        Stack<Character> list = new Stack<>();

        for (int idx = 0; idx < str.length(); idx++) {
            list.push(str.charAt(idx));
        }

        StringBuilder res = new StringBuilder("");
        while (!list.isEmpty()) {
            char top = list.pop();
            res.append(top);
        }

        return res.toString();
    }

    public static void stockSpan() {
        // find stocks span for each day

        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length]; // (index arthemetic)
        Stack<Integer> stk = new Stack<>(); // stores previous High index

        // step 1 : initializing day 1 span
        span[0] = 1;
        stk.push(0);

        // step 2 : looping through each day to find its span
        for (int day = 1; day < stocks.length; day++) {
            int currPrice = stocks[day];

            // step 2.1 : removing all the elements from stacks that are not greater or
            // equal to currPrice
            while (!stk.isEmpty() && currPrice > stocks[stk.peek()]) {
                stk.pop();
            }

            // step 3 : finding span
            if (stk.isEmpty()) {
                span[day] = day + 1;

            } else {
                int previousHigh = stk.peek();
                span[day] = day - previousHigh;
            }

            // step 4 : pushing current day price (idx) in stack
            stk.push(day);
        }

        // displaying stocks span
        for (int i = 0; i < span.length; i++) {
            System.out.println("Day " + i + ": " + span[i]);
        }
    }

    public static void nextGreaterElement() {
        // finds next greater element for every element, using stacks for O(n)

        int elements[] = { 6, 8, 0, 1, 3 };
        int nextGreater[] = new int[elements.length];
        Stack<Integer> stk = new Stack<>();
        // STACK only points at the indexes of elements, not storing their actual
        // elements

        // traversing backwards
        for (int i = elements.length - 1; i >= 0; i--) {

            // step 1 : remove smaller elements from stack
            while (!stk.isEmpty() && elements[i] >= elements[stk.peek()]) {
                stk.pop();
            }

            // no elements are greater than current element
            if (stk.isEmpty()) {
                nextGreater[i] = -1;
                // stk.push(i); // to find next greatest element

            } else {
                // next greater element is at the top of
                nextGreater[i] = elements[stk.peek()];
            }

            // pushing current element into stack for remaining elements
            stk.push(i);


            // this algorithm can be also used for -:
            // greater in the left : reverse the loop, cuz now we want stack to store the elements in the left
            // smaller in the right : reverse the while loop condition, cuz now we want to remove greater elements to find the smaller
            // smaller in the left : reverse the for loop and the while loop condition
            // greater in the right : above code
        }

        for (int j = 0; j < elements.length; j++) {
            System.out.println(elements[j] + " : " + nextGreater[j]);
        }
    }

    public static boolean validParenthesis(String str) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i);
            // opening
            if (curr == '(' || curr == '{' || curr == '[') {
                stk.push(curr);
            }

            // closing
            else {
                // no opening
                if (stk.isEmpty()) {
                    return false;
                }

                // valid pairs
                if ((stk.peek() == '(' && curr == ')') // ()
                        || (stk.peek() == '[' && curr == ']') // []
                        || (stk.peek() == '{' && curr == '}')) { // {}
                    stk.pop();
                }

                // else if ((curr >= 65 && curr <= 90) || (curr >= 90 && curr <= 120)) {
                // continue; // to ignore character in the middle
                // }

                else {
                    // not a valid pair
                    return false;
                }
            }
        }

        if (!stk.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean duplicateBrackets(String str) {
        // str is given a valid arthemetic expression

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            // if bracket is closing
            if (curr == ')') {
                int count = 0;
                // removing elements until matching pair is found
                while (stk.pop() != '(') {
                    // we used pop, cuz it returs the element is removed, 
                    // also will delete the opening bracket too
                    count++;
                }

                if (count == 0) {
                    return true;
                }

            } else {
                // for opening brackets, operands, and operators
                stk.push(curr);
            }
        }

        return false;
    }

    public static int maxArea(int heights[]) {
        int maxArea = 0;
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];
        

        // find nsl, (next smaller element in the left)
        Stack<Integer> stk = new Stack<>();
        for (int i = 0 ; i<heights.length ; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                nsl[i] = -1;
            } else { 
                nsl[i] = stk.peek();
            }

            stk.push(i);
        }
    
        // find nsr, next smaller element in right
        stk = new Stack<>();
        for (int i = heights.length - 1 ; i>=0 ; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = stk.peek();
            }
            stk.push(i);
        }

        // find area
        for (int i = 0 ; i<heights.length ; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int arr[] = {2,1,5,6,2,3};
        System.out.println(maxArea(arr));
    }
}
 