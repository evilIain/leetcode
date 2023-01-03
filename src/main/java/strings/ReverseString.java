package strings;

public class ReverseString {

    public static void reverse(char[] c) {
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    public static void main(String[] args) {
        char[] c = {'H','a','n','n','a','h'};
        reverse(c);
        System.out.println(c);

    }
}
