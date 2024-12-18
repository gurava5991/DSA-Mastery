package bitmanipulation.EasyQuestions;

public class AddTwoBinaryStrings {
    public static void main(String[] args) {
        String s1 = "1101";
        String s2 = "111";
        System.out.println(addBinary(s1,s2));
    }
    public static String addBinary(String s1, String s2) {
        // code here
        if(s2.length() > s1.length()){
            return addBinary(s2 , s1);
        }
        int carry = 0;
        int i = s1.length() - 1 , j = s2.length() - 1;
        StringBuilder res = new StringBuilder();
        while(i >= 0 && j >= 0){
            int val1 = s1.charAt(i--) - '0';
            int val2 = s2.charAt(j--) - '0';
            int sum = carry + val1 + val2;
            res.append(sum % 2);
            carry = sum / 2;
        }
        while(i >= 0){
            int val1 = s1.charAt(i--) - '0';
            int sum = val1 + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0){
            char ch = (char) (carry + '0');
            res.append(ch);
        }
        return res.reverse().toString();

    }
}
