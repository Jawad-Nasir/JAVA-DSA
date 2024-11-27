import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        
        int nums[] = {4,7,2,9,5};
        
        System.out.println("before sorting");
        System.out.println(Arrays.toString(nums));
        
        selectionSort(nums);
        
        System.out.println("after sorting");
        System.out.println(Arrays.toString(nums));

    }

    public static void selectionSort(int[] nums){
        int minIndex = -1;

        for (int i = 0; i < nums.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                } 
            }

            swap(nums, minIndex, i);
        }
    }

    public static void swap(int arr[], int index1, int index2){
            arr[index1] = arr[index1] - arr[index2];
            arr[index2] = arr[index1] + arr[index2];
            arr[index1] = arr[index2] - arr[index1];
    }
}
