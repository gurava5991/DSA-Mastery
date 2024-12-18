package StringProblems;
import java.util.*;
public class RabinKarp {
    public static void main(String[] args) {
        String pat = "geek";
        String text ="geeksforgeeks";
        System.out.println(search(pat , text));
    }
    static  ArrayList<Integer> search(String pat, String text)
    {
        // your code here
        int n = pat.length() , m = text.length();
        int hashPat = 0 , hashText = 0;

        int p = 7 , MOD = 101;

        int pLeft = 1 , pRight = 1;
        //step 1 : Calculate the hashpat and hashtext
        for(int i =  0 ; i < n ; i++){
            int currHashPat = ((pat.charAt(i) - 'a' + 1) * pRight) % MOD;
            int currHashText = ((text.charAt(i) - 'a' + 1) * pRight) % MOD;
            hashPat = (hashPat + currHashPat) % MOD;
            hashText = (hashText + currHashText) % MOD;
            pRight = (pRight * p) % MOD;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        //Traversal the text string
        for(int i = 0 ; i <= (m - n) ; i++){
            //checking if the hashPat and hashtext are matching or not
            if(hashPat == hashText){
                if(text.substring(i , i + n).equals(pat)){
                    result.add(i);
                }
            }

            //Rolling the hash
            if(i < m - n){
                //trailing the left most char in hashtext
                int leftHashText =  ((text.charAt(i) - 'a' + 1) * pLeft) % MOD;
                int rightHashText = ((text.charAt(i + n) - 'a' + 1) * pRight) % MOD;

                hashText = (hashText - leftHashText + MOD) % MOD;
                hashText = (hashText + rightHashText) % MOD;
                hashPat = (hashPat * p) % MOD;

                // updating the prime multiples
                pRight = (pRight * p) % MOD;
                pLeft = (pLeft * p) % MOD;

            }
        }

        return result;
    }
}
