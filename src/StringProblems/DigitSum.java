package StringProblems;

public class DigitSum {
    public static void main(String[] args) {
        System.out.println(digitSum("000000000", 3));
    }
    public static String digitSum(String s, int k) {
        if(s.length() <= k)
            return s;

        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            int gSum = 0;
            for(int i = 0 ; i < s.length() ; i++){
                gSum += (s.charAt(i) - '0');
                if((i + 1) % k == 0){
                    sb.append(String.valueOf(gSum));
                    gSum = 0;
                }
            }
            if(gSum != 0){
                sb.append(String.valueOf(gSum));
            }
            s = sb.toString();
        }
        return s;

    }
}
