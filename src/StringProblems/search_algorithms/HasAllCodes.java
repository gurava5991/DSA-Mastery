package StringProblems.search_algorithms;

import java.util.ArrayList;
import java.util.List;

public class HasAllCodes {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("0110", 2));

    }
    public static boolean hasAllCodes(String s, int k) {
        List<String> binaryCodes = generateBinaryCodes(k);
        for(String binaryCode : binaryCodes){
            if(!search(binaryCode , s)){
                return false;
            }
        }
        return true;

    }
    public static List<String> generateBinaryCodes(int k) {
        List<String> codes = new ArrayList<>();
        int total = 1 << k;  // 2^k

        for (int i = 0; i < total; i++) {
            String binary = Integer.toBinaryString(i);
            // Pad with leading zeros to ensure length == k
            while (binary.length() < k) {
                binary = "0" + binary;
            }
            codes.add(binary);
        }
        return codes;
    }
    public static boolean search(String pat, String txt) {
        // Code here
        // ArrayList<Integer> result = new ArrayList<Integer>();
        int m = txt.length() ,n =  pat.length();
        if(n > m)
            return false;



        int hashPat = 0 , hashTxt = 0 , pLeft = 1 , pRight = 1;
        int p = 1 , MOD = 101;

        for(int i = 0 ; i < pat.length() ; i++){
            int currTextHash = ((txt.charAt(i) - '0' + 1) * pRight ) % MOD;
            int currPatHash = ((pat.charAt(i) - '0' + 1) * pRight ) % MOD;
            hashPat = (hashPat + currPatHash) % MOD;
            hashTxt = (hashTxt + currTextHash) % MOD;
            pRight = (pRight * p) % MOD;
        }
        //ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i <= (m - n) ; i++){
            if(hashPat == hashTxt){
                if(pat.equals(txt.substring(i , i + n)))
                    return true;
            }

            if(i < (m - n)){
                int currLeftHash = ((txt.charAt(i) - '0' + 1) * pLeft ) % MOD;
                int currRightHash = ((txt.charAt(i + n) - '0' + 1) * pRight ) % MOD;
                hashTxt = (hashTxt - currLeftHash + MOD) % MOD;
                hashTxt = (hashTxt + currRightHash) % MOD;

                hashPat = (hashPat * p) % MOD;

                pLeft = (pLeft * p ) % MOD;
                pRight = (pRight * p) % MOD;
            }

        }
        return false;
    }
}
