public class WaterVol {

    public static int waterVolume(int height[]) {
        int trappedVolume = 0;
        
        int rightMax[] = new int[height.length];
        int leftMax[] = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int bar=1 ; bar<height.length ; bar++) {
            leftMax[bar] = Math.max(height[bar], leftMax[bar - 1]);
        }

        for (int bar=height.length-2 ; bar>=0 ; bar--) {
            rightMax[bar] = Math.max(height[bar], rightMax[bar + 1]);
        }

        for (int bar=0 ; bar<height.length ; bar++) {
            int waterLevel = Math.min(rightMax[bar], leftMax[bar]);
            trappedVolume = trappedVolume + (waterLevel - height[bar]);
        }        

        return trappedVolume;
    }
    public static void main(String args[]) {
        int array[] = {2,0,4,3,5,2,3};                  //2+1+1 = 4
        System.out.println("VOLUME: " + waterVolume(array));
    }
}
