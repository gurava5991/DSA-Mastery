package StringProblems;
import java.util.*;
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("CC"));

    }
    public static int romanToInt(String s) {
        Map<Character , Integer> map = Map.of(
                'I' , 1,
                'V' , 5,
                'X' , 10,
                'L' , 50,
                'C' , 100,
                'D' , 500,
                'M' , 1000
        );
        int n = s.length();
        int result = map.get(s.charAt(n - 1));
        for(int i = n - 2 ; i >= 0 ; i--){
            char currChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            if(map.get(currChar) >= map.get(nextChar) ){
                result += map.get(currChar);
            }
            else{
                result -= map.get(currChar);
            }
        }
        return result;

    }
}

