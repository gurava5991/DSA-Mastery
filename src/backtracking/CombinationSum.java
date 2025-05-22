package backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2 , 3, 6,7};
        int target = 7;
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> ds =  new ArrayList<>();
        findAllCombinations(0,arr,target,allCombinations,ds);
        System.out.println(allCombinations);

    }

    private static void findAllCombinations(int index, int[] arr, int target, List<List<Integer>> allCombinations, List<Integer> ds) {
        if(index == arr.length){
            if(target == 0)
                allCombinations.add(new ArrayList<>(ds));
            return;
        }
        //stay same index upto arr[index] > target --> pick
        if(arr[index] <= target){
            ds.add(arr[index]);
            findAllCombinations(index, arr, target - arr[index], allCombinations, ds);
            ds.remove(ds.size() - 1);
        }
        //non pick
        findAllCombinations(index + 1, arr, target, allCombinations, ds);
    }
}
