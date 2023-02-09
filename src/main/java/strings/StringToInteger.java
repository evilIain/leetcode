package strings;


public class StringToInteger {

    public static int myAtoi(String s) {

        int result = 0;
        int sign = 1;
        int i = 0;

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        if (s.charAt(0) == '+') {
            sign = 1;
            i++;
        }

        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                        if (sign == -1) {
                            return Integer.MIN_VALUE;
                        }
                        return Integer.MAX_VALUE;
                    }

                    result = result * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i = s.length();
            } else {
                return 0;
            }

        }

        return result * sign;
    }

    public static void main(String[] args) {
        String str = "  -423333";
        System.out.println(myAtoi(str));
    }
}
