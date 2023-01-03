package codinginterview.arraysstrings;

public class StringCompression_1_6 {

    public static String pack(char s, int count) {
        if (count > 1) {
            return String.valueOf(s) + count;
        }
        return String.valueOf(s);
    }

    public static String encode(String input) {
        StringBuilder output = new StringBuilder();
        int n = input.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while(i < n - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            output.append(pack(input.charAt(i), count));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "abcd";
        System.out.println(encode(input));
    }
}
