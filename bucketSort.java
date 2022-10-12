import java.util.Arrays;

public class bucketSort {

    public static void main(String[] args) {
        int[] singleSubscripted = { 105, 87142, 95, 12987120, 7194, 9 };
        BucketSort(singleSubscripted);
        System.out.println(Arrays.toString(singleSubscripted));
    }

    public static void BucketSort(int[] singleSubscripted) {
        int[][] doubleSubscripted = new int[10][singleSubscripted.length];
        int count = 0;
        while (doubleSubscripted[0][singleSubscripted.length - 1] == 0) {
            // this for-loop will find the "digit" that we're looking for of each element
            // and add them into the appropriate box of doubleSubscripted array
            for (int i = 0; i < singleSubscripted.length; i++) {
                int digit = singleSubscripted[i] / (int) Math.pow(10, count) % 10;
                int col = 0;

                // in case the first several columns of a row is taken up already
                while (doubleSubscripted[digit][col] > 0)
                    col++;
                doubleSubscripted[digit][col] = singleSubscripted[i];
            }

            // this will get all of the elements back into the singleSubscripted array
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < singleSubscripted.length; j++) {
                    if (doubleSubscripted[i][j] > 0) {
                        singleSubscripted[index] = doubleSubscripted[i][j];
                        index++;
                    }
                }
            }

            // if statement will make sure when to stop the while loop
            // if the first row of doubleSubscripted array is all ocupied
            // then break out of the while loop
            if (doubleSubscripted[0][singleSubscripted.length - 1] != 0)
                break;

            // this clears the doubleSubscripted array before continue the next loop
            for (int i = 0; i < doubleSubscripted.length; i++)
                Arrays.fill(doubleSubscripted[i], 0);
            count++;
        }
    }
}
