public class A1_duplicateElement {
    public static boolean duplicateElement(int nums[]) {
        
        //Bruteforce
        for (int first=0 ; first<nums.length ; first++) {
            for (int second=first + 1 ; second<nums.length ; second++) {
                if (nums[first] == nums[second]) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String args[]) {
        int array[] = {1,2,3,4,5};
        System.out.println(duplicateElement(array));
    }
}