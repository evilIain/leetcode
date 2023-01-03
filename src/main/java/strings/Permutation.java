package strings;

import java.util.*;

public class Permutation {

    public static boolean isPermutation(String first, String second) {
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

    public static List<String> findPermutations(String source, String target) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= target.length() - 4; i++) {
            String temp = target.substring(i, i + 4);
            if (isPermutation(source, temp)) {
                result.add(temp);
            }
        }
        return result;
    }

    public static Set<String> findAllPermutations(String source) {
        Set<String> result = new HashSet<>();
        if (source == null) {
            return null;
        }
        if (source.length() == 0) {
            result.add("");
            return result;
        }
        Character c = source.charAt(0);
        String temp = source.substring(1);
        Set<String> words = findAllPermutations(temp);
        if (words != null) {
            for (String word : words) {
                for (int i = 0; i <= word.length(); i++) {
                    result.add(insertChar(word, c, i));
                }
            }
        }

        return result;
    }

    public static String insertChar(String source, Character c, Integer position) {
        String start = source.substring(0, position);
        String end = source.substring(position);
        return start + c + end;
    }

    public static void main(String[] args) {
        String source = "abbc";
        String target = "cbabadcbbabbcbabaabccbabc";
        String perm = "ABC";
        Set<String> permutations = findAllPermutations(perm);
        List<String> result = findPermutations(source, target);
        result.forEach(System.out::println);
        permutations.forEach(System.out::println);
    }
}
