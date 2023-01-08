package algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {-10,70,-3,-8,40,30};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quicksort(int[] input, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(input, start, end);
            quicksort(input, start, pivotIndex - 1);
            quicksort(input, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (input[j] <= pivot) {
                i++;

                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        int temp = input[i + 1];
        input[i + 1] = input[end];
        input[end] = temp;

        return i + 1;
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
