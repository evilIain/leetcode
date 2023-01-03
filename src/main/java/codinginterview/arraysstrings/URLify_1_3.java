package codinginterview.arraysstrings;

public class URLify_1_3 {

    public static char[] replaceSpaces(char[] input, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ')
                spaceCount++;
        }

        int index = length + spaceCount * 2;
        if (length < input.length)
            input[length] = '\0';
        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[index - 1] = '0';
                input[index - 2] = '2';
                input[index - 3] = '%';
                index = index - 3;
            } else {
                input[index - 1] = input[i];
                index--;
            }
        }

        return input;
    }

    public static void main(String[] args) {
        String input = "Mr John Smith     ";
        System.out.println(replaceSpaces(input.toCharArray(), 13));

    }
}
