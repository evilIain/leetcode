package strings;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String palindrome = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            String temp = findPalindrome(s, i, i);
            if (temp.length() > palindrome.length())
                palindrome = temp;

            temp = findPalindrome(s, i, i + 1);
            if (temp.length() > palindrome.length())
                palindrome = temp;

        }

        return palindrome;
    }

    public static String findPalindrome(String s, int start, int end) {
        while (start >= 0 && end <= s.length() -1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    public static void main(String[] args) {
        String input = "aaaabbaa";
        System.out.println(longestPalindrome(input));
    }
}
