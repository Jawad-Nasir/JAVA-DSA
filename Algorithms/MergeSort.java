import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int nums[] = {10,8,44,2,6,4,2};
        int n = nums.length-1;

        System.out.println("before sorting:");
        System.out.println(Arrays.toString(nums));
        
        mergeSort(nums, 0, n);
        
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] arr, int l, int r){
        if (l < r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r){
        int merged[] = new int[r-l+1];

        int indx1 = l;
        int indx2 = mid +1;
        int x = 0;
        
        while (indx1 <= mid && indx2 <= r) {
            if (arr[indx1] <= arr[indx2]) {
                merged[x] = arr[indx1];
                x++; indx1++;
            } else {
                merged[x] = arr[indx2];
                x++; indx2++;
            }
        }

        while (indx1 <= mid) {
            merged[x] = arr[indx1];
            x++; indx1++;
        }

        while (indx2 <= r) {
            merged[x] = arr[indx2];
            x++; indx2++;
        }

        for (int i = 0, j = l; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
    
}
