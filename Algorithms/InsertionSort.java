import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int nums[] = {4,7,2,9,5};
        
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(nums));
        
        insertionSort(nums);
        
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;            
        }
    }
}
