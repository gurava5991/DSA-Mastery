package SortingAlgorithms;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = {2,9,7,4,1,8,4};
        int max = getMax(nums);
        int[] count = new int[max + 1];
        for(int val : nums)
            count[val]++;
        //cumulative sum
        for(int i = 1 ; i < count.length; i++){
            count[i] += count[i - 1];
        }
        int[] output = new int[nums.length];
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            output[--count[nums[i]]] = nums[i];
        }
        System.out.println(Arrays.toString(output));

    }

    //get the max element from nums array
    private static int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}
