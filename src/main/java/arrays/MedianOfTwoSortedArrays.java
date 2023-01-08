package arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);

        if (merged.length % 2 == 1) {
            return merged[merged.length/2];
        } else {
            return (double) (merged[merged.length/2] + merged[merged.length/2 - 1]) / 2;
        }
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;
        int indexMerged = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                merged[indexMerged++] = nums1[index1++];
            } else {
                merged[indexMerged++] = nums2[index2++];
            }
        }

        while(index1 < nums1.length) {
            merged[indexMerged++] = nums1[index1++];
        }

        while(index2 < nums2.length) {
            merged[indexMerged++] = nums2[index2++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,4,5};
        int[] arr2 = {3};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
