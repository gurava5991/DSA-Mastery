package array.arrayi;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        //[0,1,0,1,0,1,0,1,0,1,1,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1]
        int[] nums = {0,1,0,1,0,1,0,1,0,1,1,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1};
        int count = 0 , max_count = 0;
        for(int val : nums){
            if(val == 1){
                count++;
            }
            else{
                max_count = Math.max(max_count , count);
                count = 0;
            }
        }
        max_count = Math.max(max_count, count);
        System.out.println(max_count);
    }
}
