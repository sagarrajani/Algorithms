package Sorting;

/**
 * Created by Ash on 2/16/2017.
 */
public class MergeSort {

    private static final int INF = 100000000;
    private static int[] sequence = null;

    void merge(int[] arr, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] arrayL = new int[n1 + 1];
        int[] arrayR = new int[n2 + 1];

        for(int i = 0; i < n1; i++){
            arrayL[i] = arr[p + i];
        }

        for(int i = 0; i < n2; i++){
            arrayR[i] = arr[q + i + 1];
        }

        arrayL[n1] = INF;
        arrayR[n2] = INF;

        int i = 0;
        int j = 0;

        for(int k = p; k <= r; k++){
            if(arrayL[i] <= arrayR[j]){
                arr[k] = arrayL[i];
                i++;
            }
            else{
                arr[k] = arrayR[j];
                j++;
            }
        }
    }

    void mergesort(int[] arr, int p, int r){
        if(p < r){
            int q = ((p + r) / 2);
            mergesort(arr, p, q);
            mergesort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void main(String[] args){
        int[] input = {1, 3, 7, 3, 2, 5, 7, 1, 3, 9, 0, 1, 2, 11, 21, 12, 32, 34, 54, 37};
        sequence = input;
        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergesort(sequence,0,sequence.length - 1);

        System.out.println(INF);

        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");
    }
}
