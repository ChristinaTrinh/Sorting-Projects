
//The recursive sorting technique called Quicksort. 
import java.util.*;

public class quickSort {
    public static void main(String[] args) {
        // quickSort
        System.out.println("quickSort: ");
        // int[] array = { 37, 2, 6, 10, 37, 3, 14, 89, 77 };
        int array[] = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        QuickSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
        System.out.println();

        // quickSortViaPointers that only switches the index but not the value itself

        int nums[] = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        int sorted[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            sorted[i] = i;

        System.out.println("quickSortViaPointers: ");
        System.out.println("Unsorted Nums: ");
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sorted));
        System.out.println();
        quickSortViaPointers(nums, sorted, 0, nums.length);
        System.out.println("Sorted Nums: ");
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sorted));
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void QuickSort(int[] array, int min, int max) {
        if ((max - min) > 0) { // only recursively call the method when there are still
                               // two elements left to sort
            int pivot = min;
            int temp = 0;

            // from rightmost to left, if discover a lesser value, then swap
            for (int i = max - 1; i > pivot; i--) {
                if (array[i] < array[pivot]) {
                    swap(array, i, pivot);
                    temp = pivot;
                    pivot = i;

                    // from left to right, if discover a greater value, then swap
                    for (int j = temp + 1; j < pivot; j++) {
                        if (array[j] > array[pivot]) {
                            swap(array, j, pivot);
                            pivot = j;
                            break;
                        }
                    }
                }
            }

            // recursively call the method until all the halves are sorted
            QuickSort(array, 0, pivot);
            QuickSort(array, pivot + 1, max);

        }
    }

    public static void quickSortViaPointers(int nums[], int sorted[], int min, int max) {
        if ((max - min) > 0) { // only recursively call the method when there are
                               // two elements left to sort
            int pivot = min;
            int temp = 0;

            // from rightmost to left, if discover a lesser value, then swap
            for (int i = max - 1; i > pivot; i--) {
                if (nums[sorted[i]] < nums[sorted[pivot]]) {
                    swap(sorted, i, pivot);
                    temp = pivot;
                    pivot = i;

                    // from left to right, if discover a greater value, then swap
                    for (int j = temp + 1; j < pivot; j++) {
                        if (nums[sorted[j]] > nums[sorted[pivot]]) {
                            swap(sorted, j, pivot);
                            pivot = j;
                            break;
                        }
                    }
                }
            }

            // recursively call the method until all the halves are sorted
            quickSortViaPointers(nums, sorted, 0, pivot);
            quickSortViaPointers(nums, sorted, pivot + 1, max);
        }

    }

}
