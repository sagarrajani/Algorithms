package Sorting;

/**
 * Created by Ash on 2/16/2017.
 */
public class QuickSort {

    private static int[] sequence = null;

    public void quicksort(int[] arr, int p, int r){
        if(p < r){
            int q = partition(arr, p, r);
            quicksort(arr, p, q - 1);
            quicksort(arr, q + 1, r);
        }
    }

    public int partition(int[] arr, int p, int r){
        int x = arr[r];
        int i = p - 1;
        int temp = 0;

        for(int j = p; j < r; j++){
            if(arr[j] <= x){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[r] = temp;
        arr[i + 1] = x;

        return i + 1;
    }

    public static void main(String[] args){
        int[] input = {1, 3, 7, 3, 2, 5, 7, 1, 3, 9, 0, 1, 2, 11, 21, 12, 32, 34, 54, 37};
        sequence = input;
        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");

        System.out.println();

        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(sequence, 0, sequence.length - 1);

        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");
    }
}
