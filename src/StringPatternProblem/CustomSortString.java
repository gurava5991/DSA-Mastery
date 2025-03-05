package StringPatternProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomSortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = sc.nextLine();
        String s = sc.nextLine();
        System.out.println(customSortString(order,s));
    }

    private static String customSortString(String order,String s) {
        Map<Character , Character> map = Map.of();
        Map<Character,Integer> frequency  = new HashMap<>();
        for(char ch : s.toCharArray())
                frequency.put(ch,frequency.getOrDefault(ch , 0) + 1);
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < order.length() ; i++){
            char ch = order.charAt(i);
            if(frequency.containsKey(ch)){
                int count = frequency.get(ch);
                for(int j = 0 ; j < count ; j++){
                    res.append(ch);
                }
                frequency.remove(ch);
            }
        }
        for(char ch : frequency.keySet()){
            int count = frequency.get(ch);
            for(int i = 0 ; i < count ; i++){
                res.append(ch);
            }
        }
        return res.toString();
    }
}
