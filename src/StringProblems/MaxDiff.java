package StringProblems;

public class MaxDiff {
    public static void main(String[] args) {
        MaxDiff obj = new MaxDiff();
        System.out.println(obj.maxDiff(123456));
    }
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }

        for(int i = 0 ; i < s.length() ; i++){
            char digit = t.charAt(i);
            if(i == 0){
                if(digit != '1'){
                    t = t.replace(digit , '1');
                    break;
                }
            }
            else{
                if(digit != '0' && digit != t.charAt(0)){
                    t = t.replace(digit , '0');
                }
            }
        }
        return  Integer.parseInt(s)-Integer.parseInt(t);

    }
}
