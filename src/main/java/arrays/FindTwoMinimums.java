package arrays;

public class FindTwoMinimums {

    public static int findMinimums(int[] array) {

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < firstMin) {
                secondMin = firstMin;
                firstMin = array[i];
            } else if (array[i] < secondMin) {
                secondMin = array[i];
            }
        }

        return firstMin * secondMin;
    }

    public static void main(String[] args) {
        int[] array = {1,5,2,5,1};
        System.out.println(findMinimums(array));
    }
}
