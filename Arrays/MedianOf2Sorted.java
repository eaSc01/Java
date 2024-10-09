package Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;

        Integer e1 = null;
        Integer e2 = null;

        int e2Idx = n / 2 ;
        int e1Idx = e2Idx - 1;

        int i = 0, j = 0, k = 0;

        // get e1 and e2
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (k == e1Idx) {
                    e1 = nums1[i];
                }
                if (k == e2Idx) {
                    e2 = nums1[i];
                }
                i++;
                k++;

            } else {
                if (k == e1Idx) {
                    e1 = nums2[j];
                }
                if (k == e2Idx) {
                    e2 = nums2[j];
                }
                j++;
                k++;
            }
        }

        while (i < nums1.length) {
            if (k == e1Idx) {
                e1 = nums1[i];
            }
            if (k == e2Idx) {
                e2 = nums1[i];
            }
            i++;
            k++;
        }

        while (j < nums2.length) {
            if (k == e1Idx) {
                e1 = nums2[j];
            }
            if (k == e2Idx) {
                e2 = nums2[j];
            }
            j++;
            k++;
        }

        if (n % 2 == 1) {
            return (double) e2;
        }

        return (double) (e1 + e2) / 2;
    }
}