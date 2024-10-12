public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 0, 6, 3, 2, 5 };

        int trappedRainwater = trap(arr);
        System.out.println("Trapped Rainwater: " + trappedRainwater);
    }

    private static int calculateTrappedRainwater(int[] height) {
        int trappedRainwater = 0;

        int[] tallestLeft = new int[height.length];
        int[] tallestRight = new int[height.length];

        // calculating tallest left for each bar
        tallestLeft[0] = 0;
        for (int i = 1; i < tallestLeft.length; i++) {
            tallestLeft[i] = Math.max(tallestLeft[i - 1], height[i - 1]);
        }

        // calculating tallest right for each bar
        tallestRight[tallestRight.length - 1] = 0;
        for (int i = tallestRight.length - 2; i >= 0; i--) {
            tallestRight[i] = Math.max(tallestRight[i + 1], height[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int x = height[i];
            int w = Math.min(tallestLeft[i], tallestRight[i]);
            int waterOnCurrBar = (w - x) * 1;
            System.out.println(waterOnCurrBar);

            if (waterOnCurrBar > 0) {
                trappedRainwater += waterOnCurrBar;
            }
        }

        return trappedRainwater;
    }

    public static int trap(int[] height) {
        int water = 0;

        int left = 0;
        int right = height.length - 1;

        int tallestLeft = height[left];
        int tallestRight = height[right];
        
        
        while (left < right) {

            if (tallestLeft < tallestRight) {
                left++;
                tallestLeft = Math.max(tallestLeft, height[left]);
                water += (tallestLeft - height[left]);

            } else {
                right--;
                tallestRight = Math.max(tallestRight, height[right]);
                water += (tallestRight - height[right]);
            }

        }

        return water;
    }
}
