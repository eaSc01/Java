package Arrays;

public class TrappingRainwater {

    public static int trappingRainwater(int height[]) {
        int totalTrappedWater = 0;

        //auxillary arrays
        int rightMax[] = new int[height.length];
        int leftMax[] = new int[height.length];

        //assigning initials
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        //finding left max element for each element
        for (int currbar=1 ; currbar<leftMax.length ; currbar++) {
            leftMax[currbar] = Math.max(leftMax[currbar - 1], height[currbar]);
        }

        //finding right max element for each element
        for (int currbar=rightMax.length-2 ; currbar >= 0 ; currbar-- ) {
            rightMax[currbar] = Math.max(rightMax[currbar + 1], height[currbar]);
        }

        //finding Total volume of the trapped water
        for (int currBar = 0 ; currBar<height.length - 1 ; currBar++ ) {
            int waterLevel = Math.min(rightMax[currBar], leftMax[currBar]);
            totalTrappedWater += waterLevel - height[currBar];
        }

        return totalTrappedWater;
    }
    
    public static void main(String args[]) {
        int elevationBars[] = {4, 2, 0, 3, 2, 5};
        System.out.println(trappingRainwater(elevationBars));
    }
}
