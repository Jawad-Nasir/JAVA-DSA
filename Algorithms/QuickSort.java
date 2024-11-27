import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int nums[] = {10,8,44,2,6,4,2};
        int n = nums.length-1;

        System.out.println("before sorting:");
        System.out.println(Arrays.toString(nums));
        
        quickSort(nums, 0, n);
        
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] arr, int low, int high){
         
        if ( low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);    
            quickSort(arr, pivot+1, high);
        }
        
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);               
            }
        }
        swap(arr, low, j);

        return j;
    }

    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

