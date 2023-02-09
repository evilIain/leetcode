package arrays;

import java.util.*;

public class SumOfThree {

    public static List<List<Integer>> threeSumv2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Set<Integer> duplicatedSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if (!duplicatedSet.add(nums[i]))
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                int value = -nums[i] - nums[j];
                if (map.containsKey(value) && map.get(value) == i) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], value));
                    Collections.sort(list);
                    result.add(list);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> set = sumOfTwo(i + 1, nums, -nums[i]);
            if (!set.isEmpty()) {
                result.addAll(set);
            }
        }
        return new ArrayList<>(result);
    }

    public Set<List<Integer>> sumOfTwo(int from, int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();
        for (int i = from; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                List<Integer> list = new ArrayList<>(List.of(temp, nums[i], -target));
                Collections.sort(list);
                result.add(list);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSumv2(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
