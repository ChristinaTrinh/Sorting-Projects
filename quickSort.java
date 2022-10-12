
//The recursive sorting technique called Quicksort. 
import java.util.*;

public class quickSort {
    public static void main(String[] args) {
        int[] array = { 37, 2, 6, 10, 4, 3, 14, 89, 77 };
        QuickSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
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
}
