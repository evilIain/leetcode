package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicates {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = 1;
            if (!map.containsKey(num)) {
                map.put(num, count);
            } else
                map.put(num, ++count);
        }
        for (Integer values : map.values()) {
            if (values > 1)
                return true;
        }
        return false;
    }

    public static boolean containsDuplicatev2(int[] nums) {
        if (nums.length <= 1)
            return false;
        Arrays.sort(nums);

        int temp = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num != temp) {
                temp = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicatev2(nums));
    }
}
