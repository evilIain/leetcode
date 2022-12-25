package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] input = {3,2,4};

        System.out.println(Arrays.toString(twoSum(input, 6)));
    }
}
