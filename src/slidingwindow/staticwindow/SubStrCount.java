package slidingwindow.staticwindow;

import java.util.HashMap;
import java.util.Map;

class SubStrCount {
    public static void main(String[] args) {
        System.out.println(substrCount("abcc" , 2));
    }
    public static int substrCount(String s, int k) {
        // code here
        int cnt = 0;
        int j = 0;
        Map<Character , Integer> freq = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            freq.put(ch , freq.getOrDefault(ch , 0) + 1);
            if(i >= (k - 1)){
                if(freq.size() == (k - 1)){
                    cnt++;
                }
                char startChar = s.charAt(j++);
                freq.put(startChar , freq.getOrDefault(startChar , 0) - 1);
                if(freq.get(startChar) == 0){
                    freq.remove(startChar);
                }
            }

        }
        return cnt;
    }
}
