package strings;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        int reverse = 0;
        while (x > 0) {
            int temp = x % 10;
            reverse = reverse * 10 + temp;
            x = x / 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }


}
