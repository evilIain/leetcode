package arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; i++, j++) {
            if (nums[i] == 0) {
                while (nums[j] == 0 && j < nums.length - 1) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,0,0,0,2,0,0,0,3};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
