package StringProblems;


public class SameFreq {
    static boolean sameFreq(String s) {
        // code here
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] == 0) continue;
            freq[i]--;
            if(isValid(freq))
                return true;
            //backtracking
            freq[i]++;
        }
        return false;
    }
    public static boolean isValid(int[] freq){
        int expected = 0;
        for(int f : freq){
            if(f == 0)
                continue;
            if(expected == 0)
                expected = f;
            else if(expected != f)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(sameFreq("xxxxyyzz"));

    }
}
