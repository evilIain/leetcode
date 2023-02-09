package arrays;

public class LongestArrayOfOnes {

    public static int longestSubArray(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        int result = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                temp++;
                if (temp > result) {
                    result = temp;
                }
            } else {
                temp = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,1};
        System.out.println(longestSubArray(arr));
    }
}
