package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                maxLength = Math.max(maxLength, set.size());
            }
            else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcbca";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
