
//This project sorts the array in different ways
//Uncomment each sorting version for every execute
//***Notice the running time for shuffle version*** 
import java.util.*;

public class variousSortingKinds {
    public static void main(String[] args) {
        int[] array = { 3, 1, 342, 2334, 12, 1 };

        /*
         * selectionSortModified(array);
         * System.out.println(Arrays.toString(array));
         */

        /*
         * selectionSortDualVersion(array);
         * System.out.println(Arrays.toString(array));
         */

        /*
         * shuffle(array);
         * System.out.println(Arrays.toString(array));
         */

        /*
         * bogoSort(array);
         * System.out.println(Arrays.toString(array));
         */
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectionSortModified(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int largest = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[largest])
                    largest = j;
            }
            swap(array, i, largest);
        }
    }

    public static void selectionSortDualVersion(int[] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            int smallest = i;
            for (int j = i + 1; j <= lastIndex; j++) {
                if (array[j] < array[smallest])
                    smallest = j;
            }
            swap(array, i, smallest);

            int largest = i;
            for (int j = i + 1; j <= lastIndex; j++) {
                if (array[j] > array[largest])
                    largest = j;
            }
            swap(array, lastIndex, largest);
            lastIndex--;
        }
    }

    public static void shuffle(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = r.nextInt(array.length - i) + i;
            swap(array, i, j);
        }
    }

    // Use shuffle to sort an array (a silly approach)
    // The program will shuffle the array around until it is sorted
    // SURPRISE!!! IT WILL EVENTUALLY BE SORTED IF YOU LEAVE IT RUN LONG ENOUGH
    public static void bogoSort(int[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
                break;
            }
        }

        while (!sorted) {
            shuffle(array);
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1])
                    sorted = false;
            }
        }
    }
}
