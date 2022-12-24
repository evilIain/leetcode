package arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[++cur] = nums[i];
            }
        }
        return Arrays.copyOf(nums, cur + 1);

    }

    public static int[] removeDuplicatesInOneLine(int[] nums) {
        return Arrays.stream(nums).distinct().toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,4,4,6,6,6};

        int[] resultFirst = removeDuplicates(nums);
        int[] result = removeDuplicatesInOneLine(nums);
        System.out.println(Arrays.toString(resultFirst));
        System.out.println(Arrays.toString(result));
    }
}
