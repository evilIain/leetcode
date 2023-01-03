package codinginterview.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation_1_2 {

    public static boolean isPermutation(String first, String second) {
        if (first.length() != second.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : first.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : second.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutationSorted(String first, String second) {
        return sortString(first).equals(sortString(second));
    }

    public static String sortString(String input) {
        char[] charInput = input.toCharArray();
        Arrays.sort(charInput);
        return Arrays.toString(charInput);
    }

    public static void main(String[] args) {
        String source = "abbc";
        String target = "cbab";
        System.out.println(isPermutation(source, target));
        System.out.println(isPermutationSorted(source, target));
    }


}
