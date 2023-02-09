package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-10,70,-3,-8,40,30};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        List<? super Object> listSuperInteger_ListNumber  = new ArrayList<>();
        listSuperInteger_ListNumber.add(3.5);
        listSuperInteger_ListNumber.add("four");
    }

    public static void bubbleSort(int[] input) {
        int n = input.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] input) {
        int n = input.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }

            int temp = input[min];
            input[min] = input[i];
            input[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
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
