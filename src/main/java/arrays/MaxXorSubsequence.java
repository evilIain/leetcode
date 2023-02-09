package arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxXorSubsequence {

    public static int maxSubsequenceLength(int k, List<Integer> arr) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr.get(0), 1);

        int maxResult = 0;

        int[] longestSub = new int[arr.size()];
        longestSub[0] = 1;

        for (int i = 1; i < arr.size(); i++) {
            Integer temp = map.get(arr.get(i) ^ k);

            if (temp != null) {
                longestSub[i] = Math.max(longestSub[i], temp + 1);
            }

            maxResult = Math.max(maxResult, longestSub[i]);
            map.put(arr.get(i), Math.max(map.getOrDefault(arr.get(i), 1), longestSub[i]));
        }

        return maxResult;
    }

    public static void main(String[] args) {

        List<Integer> array = List.of(3,1,2,3,2);
        System.out.println(maxSubsequenceLength(1,array));
    }


}
