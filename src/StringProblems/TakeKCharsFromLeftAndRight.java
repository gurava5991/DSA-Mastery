package StringProblems;

public class TakeKCharsFromLeftAndRight {
    public static void main(String[] args) {
        String s = "abc";
        int k = 1;
        System.out.println(takeCharacters(s,k));
    }

    private static int takeCharacters(String s, int k) {
        int ans = Integer.MAX_VALUE;
        int start = 0 , end = s.length();
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isValid(s , k ,mid)){
                ans = Math.min(ans , mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static boolean isValid(String s, int k, int target) {
        int[] freq = new int[3];
        for(int i = 0 ; i < target ; i++){
            freq[s.charAt(i)-'a']++;
        }
        if(isSatisfied(freq , k)){
            return true;
        }
        int left = target - 1;
        int right = s.length() - 1;
        while(left >= 0){
            freq[s.charAt(left--)-'a']--;
            freq[s.charAt(right--)-'a']++;
            if(isSatisfied(freq,k)){
                return true;
            }
        }
        return false;

    }

    private static boolean isSatisfied(int[] freq, int k) {
        return freq[0] >= k && freq[1] >= k && freq[2] >= k;
    }

}
