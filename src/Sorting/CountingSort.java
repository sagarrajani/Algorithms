package Sorting;

/**
 * Created by Ash on 2/16/2017.
 */
public class CountingSort {

    public int[] countingsort(int[] sequence){
        int[] orderedSequence = new int[sequence.length];

        int max = -1;
        for(int i = 0; i < sequence.length; i++){
            if(max < sequence[i]){
                max = sequence[i];
            }
        }
        int[] countingArray = new int[max + 1];

        for(int i = 0; i < sequence.length; i++){
            countingArray[sequence[i]] += 1;
        }

        for(int i = 1; i <= max; i++){
            countingArray[i] += countingArray[i - 1];
        }

        for(int i = sequence.length - 1; i >= 0; i--){
            orderedSequence[countingArray[sequence[i]] - 1] = sequence[i];
            countingArray[sequence[i]] -= 1;
        }
        return orderedSequence;
    }

    public static void main(String[] args){
        int[] sequence = {5, 2, 4, 6, 1, 3, 1, 5, 3, 2, 5, 2, 7, 1, 2, 3, 4, 2, 5, 2, 1, 4, 0, 0, 0, 0};

        CountingSort countingSort = new CountingSort();
        int[] orderedSequence = countingSort.countingsort(sequence);

        for(int i = 0; i < orderedSequence.length; i++){
            System.out.print(orderedSequence[i] + " ");
        }
    }
}
