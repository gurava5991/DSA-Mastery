package greedy;

public class MaxSubSequence {
    public static void main(String[] args) {
        System.out.println(maxSubseq("ritz", 2));

    }
    public static String maxSubseq(String s, int k) {
        // code here
        StringBuilder sb = new StringBuilder();
        int toRemove = k , n = s.length();
        for(int i = 0 ; i < n ; i++){
            while (sb.length() > 0 && toRemove > 0 && sb.charAt(sb.length() - 1) <  s.charAt(i)){
                sb.deleteCharAt(sb.length() - 1);
                toRemove--;
            }
            sb.append(s.charAt(i));
        }
        return sb.substring(0 , n - k);
    }
}
