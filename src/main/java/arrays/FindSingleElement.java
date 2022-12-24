package arrays;

public class FindSingleElement {

    public static int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,5,5,6,6};
        System.out.println(singleNumber(nums));
    }
}
