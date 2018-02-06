package Sorting;

import DataStructures.MaxHeap;

/**
 * Created by Ash on 2/16/2017.
 */
public class HeapSort {

    private static int[] sequence = null;

    public void heapsort(int[] arr){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.buildmaxheap(arr);
        int heapSize = arr.length;
        for(int i = arr.length - 1; i >= 1; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            maxHeap.maxheapify(arr, 0, heapSize);
        }
    }

    public static void main(String[] args){
        HeapSort heapSort = new HeapSort();
        int[] input = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        sequence = input;
        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");

        System.out.println();

        heapSort.heapsort(sequence);

        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");
    }
}
