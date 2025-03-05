package StringProblems;

import java.util.Scanner;

public class IntToRoman {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(intToRoman(num));
        input.close();
    }

    private static String intToRoman(int num) {
        String roman = "";
        for(int i = 0 ; num > 0 ; i++){
            if(num >= values[i]){
                roman += symbols[i].repeat(num/ values[i]);
                num = num % values[i];

            }
        }
        return roman;
    }
}
