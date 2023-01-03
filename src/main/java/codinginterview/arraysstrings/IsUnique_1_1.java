package codinginterview.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class IsUnique_1_1 {

    public static boolean isUniqueString(String input) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, 1);
        }
        return true;
    }


    public static void main(String[] args) {
        String input = "hutg9mnd!nk9";
        System.out.println(isUniqueString(input));
    }
}

