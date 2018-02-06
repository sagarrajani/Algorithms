package Sorting;

/**
 * Created by Ash on 2/16/2017.
 */
public class RadixSort {

    public int numberOfDigits(int num){
        int k = 1;
        while(num / 10 != 0){
            num = num / 10;
            k++;
        }
        return k;
    }

    public int significantDigit(int num, int k){
        int digit = 0;
        for(int i = 0; i < k; i++){
            digit = num % 10;
            num = num / 10;
        }
        return digit;
    }

    public int[] modifiedCountingSort(int[] sequence, int k){
        int[] orderedSequence = new int[sequence.length];

        int max = -1;
        for(int i = 0; i < sequence.length; i++){
            if(max < significantDigit(sequence[i], k)){
                max = significantDigit(sequence[i], k);
            }
        }
        int[] countingArray = new int[max + 1];

        for(int i = 0; i < sequence.length; i++){
            countingArray[significantDigit(sequence[i], k)] += 1;
        }

        for(int i = 1; i <= max; i++){
            countingArray[i] += countingArray[i - 1];
        }

        for(int i = sequence.length - 1; i >= 0; i--){
            orderedSequence[countingArray[significantDigit(sequence[i], k)] - 1] = sequence[i];
            countingArray[significantDigit(sequence[i], k)] -= 1;
        }
        return orderedSequence;
    }

    public static void main(String[] args){
        int[] input = {329, 457, 657, 839, 436, 720, 1355};
        int[] orderedSequence = input;
        int max = -1;
        for(int i = 0; i < input.length; i++){
            if(max < input[i]){
                max = input[i];
            }
        }

        RadixSort radixSort = new RadixSort();

        int maxDigits = radixSort.numberOfDigits(max);
        System.out.println(maxDigits);
        for(int i = 1; i <= maxDigits; i++){
            orderedSequence = radixSort.modifiedCountingSort(orderedSequence, i);
        }

        for(int i = 0; i < orderedSequence.length; i++){
            System.out.print(orderedSequence[i] + " ");
        }

    }
}
