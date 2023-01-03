package codinginterview.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class PalindromPermutation_1_4 {

    public static boolean checkPermutation(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toLowerCase().toCharArray()) {
            if (c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return isPalindromePossible(map);
    }

    public static boolean isPalindromePossible(Map<Character, Integer> map) {
        boolean flag = false;
        for (int value : map.values()) {
            if (value % 2 == 1) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "Taco cat";
        System.out.println(checkPermutation(str));
    }
}
