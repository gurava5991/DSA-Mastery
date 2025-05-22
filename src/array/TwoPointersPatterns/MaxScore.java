package array.TwoPointersPatterns;

public class MaxScore {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));


    }
    public static int maxScore(String s) {
        int totalOnes = 0 , zerosCnt = 0 , onesCnt = 0 , bestScore = Integer.MIN_VALUE;
        char[] charArray = s.toCharArray();
        for(char ch : charArray){
            if(ch == '1')
                totalOnes++;
        }
        for(int i = 0 ; i < charArray.length - 1 ; i++){
            if(charArray[i] == '0')
                zerosCnt++;
            else
                onesCnt++;
            bestScore = Math.max(bestScore , zerosCnt + (totalOnes - onesCnt));
        }

        return bestScore;
    }
}
