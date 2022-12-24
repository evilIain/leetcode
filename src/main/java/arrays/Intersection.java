package arrays;

import java.util.*;

public class Intersection {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (Integer value : list) {
            result[i++] = value;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5,9};
        int[] nums2 = {9,4,9,8,4,9};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
