public class TrappingRainwater {

    public static int waterVol(int bars[]) {    //bars is the formal array, bar is the iterator
        int volumeWater = 0;
        int waterLevel = 0;

        int rightMax[] = new int[bars.length];  //stores maximum element on the right of each element
        int leftMax[] = new int[bars.length];   //stores maximum element on the left of each element

        
        leftMax[0] = bars[0];                               //counting leftmax from left to right, i.e, initialized first element to left max
        rightMax[bars.length - 1] = bars[bars.length - 1];  //counting rightmax from right to left, i.e, initialized last element to right max

        for (int bar = 1 ; bar<bars.length ; bar++) {               //calculating left Max bar of each bar
            leftMax[bar] = Math.max(leftMax[bar - 1], bars[bar]);   
        }

        for (int bar = bars.length - 2 ; bar >= 0 ; bar--) {        //calculating right Max bar of each bar, reversed* of leftMax
            rightMax[bar] = Math.max(rightMax[bar + 1], bars[bar]);
        }

        for (int bar = 0 ; bar<bars.length ; bar++) {               //calculating waterLevel of each bar,
            waterLevel = Math.min(leftMax[bar], rightMax[bar]);     //also, summing up water volume using = (Water Level - Current Bar Height)
            volumeWater += waterLevel - bars[bar];
        }

        return volumeWater;
    }
    public static void main(String args[]) {
        int height[] = {4,2,0,6,3,2,5};

        System.out.println("Water Volume: " + waterVol(height));
    }
}