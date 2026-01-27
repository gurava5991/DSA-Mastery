package SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = -1 , high = nums.length;
        int mid = 0;
        while(mid < high){
            if(nums[mid] == 0){
                low++;
                mid++;
                swap(nums , low , mid);
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                high--;
                swap(nums , mid , high);
            }
        }

    }
    public void swap(int[] nums,int pos1 ,int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] arr = {2,0,2,1,1,0};
        System.out.println("Before sorting" + Arrays.toString(arr));
        sortColors.sortColors(arr);
        System.out.println("After sorting" + Arrays.toString(arr));
    }
}
