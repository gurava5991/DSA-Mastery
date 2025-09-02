package StringProblems.search_algorithms;

import java.util.ArrayList;

public class RabinKarpAlgorithm {
    public static void main(String[] args) {
        String txt = "ydvc" , pat = "dvc" ;
        System.out.println(search(pat , txt));

    }
    static ArrayList<Integer> search(String pat, String txt) {
        // Code here
        int hashPat = 0 , hashTxt = 0 , pLeft = 1 , pRight = 1;
        int p = 1 , MOD = 101;

        for(int i = 0 ; i < pat.length() ; i++){
            int currTextHash = ((txt.charAt(i) - 'a' + 1) * pRight ) % MOD;
            int currPatHash = ((pat.charAt(i) - 'a' + 1) * pRight ) % MOD;
            hashPat = (hashPat + currPatHash) % MOD;
            hashTxt = (hashTxt + currTextHash) % MOD;
            pRight = (pRight * p) % MOD;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = txt.length() ,n =  pat.length();
        for(int i = 0 ; i <= (m - n) ; i++){
            if(hashPat == hashTxt){
                if(pat.equals(txt.substring(i , i + n)))
                    result.add(i + 1);
            }

            if(i < (m - n)){
                int currLeftHash = ((txt.charAt(i) - 'a' + 1) * pLeft ) % MOD;
                int currRightHash = ((txt.charAt(i + n) - 'a' + 1) * pRight ) % MOD;
                hashTxt = (hashTxt - currLeftHash + MOD) % MOD;
                hashTxt = (hashTxt + currRightHash) % MOD;

                hashPat = (hashPat * p) % MOD;

                pLeft = (pLeft * p ) % MOD;
                pRight = (pRight * p) % MOD;
            }

        }
        return result;
    }
}
