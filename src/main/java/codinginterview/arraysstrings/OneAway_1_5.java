package codinginterview.arraysstrings;

public class OneAway_1_5 {

    public static boolean checkOneWay(String s1, String s2) {
        if (s1.length() == s2.length())
            return checkIfSameLength(s1, s2);
        if (s1.length() == s2.length() + 1)
            return checkIfOneEdit(s2, s1);
        if (s1.length() == s2.length() - 1)
            return checkIfOneEdit(s1, s2);
        return false;
    }

    public static boolean checkIfSameLength(String s1, String s2) {
        boolean diff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff)
                    return false;
                diff = true;
            }
        }
        return true;
    }

    public static boolean checkIfOneEdit(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "bale";
        String s2 = "baile";

        System.out.println(checkOneWay(s1,s2));
    }
}
