import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int nums[] = {12,6,4,2};

        System.out.println("Elements before sorting");
        System.out.println(Arrays.toString(nums));

        bubbleSort(nums);

        System.out.println("Elements after sorting");  
        System.out.println(Arrays.toString(nums));

    }

    public static void bubbleSort(int[] nums){

        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j < nums.length; j++){
                if (nums[j] < nums[j-1]){
                    nums[j] = nums[j] - nums[j-1];
                    nums[j-1] = nums[j] + nums[j-1];
                    nums[j] = nums[j-1] - nums[j];
                    
                }
            }
        }
    }
}
