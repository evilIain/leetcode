package strings;

import java.util.*;

public class LetterCombinationsOnPhone {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Queue<String> queue = new ArrayDeque<>();
        int[] digitsArray = new int[digits.length()];

        for(int i = 0; i < digits.length(); i++) {
            digitsArray[i] = digits.charAt(i) - '0';
        }

        queue.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letter = letters[digitsArray[i] - 2];
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String temp = queue.remove();
                for (char c : letter.toCharArray()) {
                    queue.add(temp + c);
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static String translate(String text) {
        StringBuilder builder = new StringBuilder();
        int i = text.length() - 1;
        while (i >= 0) {
            char c = text.charAt(i);
            if (isVowel(c)) {
                builder.append(c);
                i = i - 3;
            } else {
                builder.append(c);
                i = i - 1;
            }
        }

        return builder.reverse().toString();
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }


    public static void main(String[] args) {
//        String digit = "234";
//        System.out.println(Arrays.toString(letterCombinations(digit).toArray()));

        String text = "cavodavingavamave, cavodavingavamave, cavodavingavamave";
        System.out.println(translate(text));
    }
}
