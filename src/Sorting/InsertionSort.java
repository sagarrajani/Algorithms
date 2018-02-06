package Sorting;

/**
 * Created by Ash on 2/12/2017.
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] sequence = {5, 2, 4, 6, 1, 3};
        for(int i = 1; i < sequence.length; i++){
            int key = sequence[i];
            int j = i - 1;
            while(j > -1 && sequence[j] > key){
                sequence[j + 1] = sequence[j];
                j = j - 1;
            }
            sequence[j + 1] = key;
        }
        for(int i = 0; i < sequence.length; i++){
            System.out.println(sequence[i]);
        }
    }
}
