package Arrays;

import java.util.ArrayList;

public class ContainerMW {

    public static int containerMWBruteForce(ArrayList<Integer> heights) {
        int mostWater = 0;
        
        for (int leftHeight = 0; leftHeight < heights.size(); leftHeight++) {
            for (int rightHeight = leftHeight + 1; rightHeight < heights.size(); rightHeight++) {
               
                int containerHeight = Math.min(heights.get(leftHeight), heights.get(rightHeight));
                int containerWidth = rightHeight - leftHeight;

                mostWater = Math.max(mostWater, containerWidth * containerHeight);
            }
        }

        return mostWater;
    }

    public static int containerMWTwoPointers(ArrayList<Integer> heights) {
        int mostWater = 0;

        // initializing first and last heights as container heights and calculating their water volume
        int leftHeightIdx = 0; // traverses in forward direction
        int rightHeightIdx = heights.size() - 1;    // traverses in backward dir (cuz initailized with the end height)

        while (leftHeightIdx < rightHeightIdx) {
            // will run till left idx < right idx, else duplicate containers will be traversed

            // calculating height, width, and volume
            int containerHeight = Math.min(heights.get(leftHeightIdx), heights.get(rightHeightIdx));
            int containerWidth = rightHeightIdx - leftHeightIdx;
            mostWater = Math.max(mostWater, containerHeight * containerWidth);

            // 2 pointer Approach, selection of next container boundaries
            //  if left height is smaller, switch it to its next height, else if right height of container is smaller,
            //  then switch it to its prev height, because the water level is controlled by the minimum of both heights.

            if (heights.get(leftHeightIdx) < heights.get(rightHeightIdx)) {
                leftHeightIdx++;

            } else { // heights.get(leftHeightIdx) >= heights.get(rightHeightIdx)
                rightHeightIdx--;
            }
        }

        return mostWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        System.out.println("Container with Most Water: " + containerMWBruteForce(list));
        System.out.println("Container with Most Water: " + containerMWTwoPointers(list));
    }
}