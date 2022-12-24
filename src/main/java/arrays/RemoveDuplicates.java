package arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                nums[++cur] = nums[i];
            }
        }
        return cur + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2}; // Input array
        int[] expectedNums = {1,2}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
