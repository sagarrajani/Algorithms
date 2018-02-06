package DataStructures;

/**
 * Created by Ash on 2/16/2017.
 */
public class MaxHeap {

    private static int[] sequence = null;

    public int parent(int index){
        return (index / 2);
    }
    
    public int left(int index){
        return (2 * index);
    }
    
    public int right(int index){
        return ((2 * index) + 1);
    }

    public void maxheapify(int arr[], int rootIndex, int length){
        int leftIndex = left(rootIndex);
        int rightIndex = right(rootIndex);

        int largest;

        if(leftIndex < length && arr[leftIndex] > arr[rootIndex]){
            largest = leftIndex;
        }
        else{
            largest = rootIndex;
        }
        if(rightIndex < length && arr[rightIndex] > arr[largest]){
            largest = rightIndex;
        }
        if(largest != rootIndex){
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;

            maxheapify(arr, largest, length);
        }
    }

    public void buildmaxheap(int[] arr){
        for(int i = (arr.length / 2) + 1; i >= 0; i--){
            maxheapify(arr, i, arr.length);
        }
    }

    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap();
        int[] input = {4, 8, 10, 2, 7, 9, 3, 1};
        sequence = input;
        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");

        maxHeap.buildmaxheap(sequence);

        System.out.println();

        for(int i = 0; i < sequence.length; i++)
            System.out.print(sequence[i] + " ");
    }
}
