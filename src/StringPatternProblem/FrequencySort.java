package StringPatternProblem;

import java.util.*;
import java.util.Collection;

public class FrequencySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(frequencySort(s));
    }

    private static String frequencySort(String s) {
        Map<Character , Integer> charCount =  new HashMap<>();
        for(char ch : s.toCharArray()){
            charCount.put(ch , charCount.getOrDefault(ch , 0) + 1);
        }
        List<Character> sortedSet = new ArrayList<Character>(charCount.keySet());
        Collections.sort(sortedSet , new Comparator<Character>(){
            @Override
            public int compare(Character a , Character b){
                return charCount.get(b) - charCount.get(a);
            }
        });
        StringBuilder result = new StringBuilder();
        for(char ch : sortedSet){
            int count = charCount.get(ch);
            for(int i = 0; i < count ; i++){
                result.append(ch);
            }
        }
        return result.toString();
    }
}

/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Constraints:
1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
 */
