package arrays;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {-10,70,-3,-8,40,30};
        quicksort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void quicksort(int[] input, int start, int end) {

        if (end - start < 2)
            return;

        int pivotIndex = findPivotIndex(input, start, end);
        quicksort(input, start, pivotIndex);
        quicksort(input, pivotIndex + 1, end);
    }

    public static int findPivotIndex(int[] input, int start, int end) {
        int i = start;
        int j = end;
        int pivot = input[start];

        while(i < j) {

            while(i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            while(i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
}
