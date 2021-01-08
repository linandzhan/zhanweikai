package 字符串练习;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个字符串相乘
 */
public class XiangCheng {
    public static String multiply(String num1, String num2) {
        int flag =0;

        int min = Math.min(num1.length(), num2.length());
        int max = Math.max(num1.length(),num2.length());
        int[][] arr = new int[min][max+1];
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0 ; j--) {
                int c1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                int c2 = Integer.parseInt(String.valueOf(num2.charAt(j)));

                int a = c1 * c2 + flag;
                flag = a/10;
                arr[i][j] = a%10;
            }
        }

        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
//                 arr[i][]
            }
        }

//        arr[]


        return null;
    }

    public static void main(String[] args) {
        multiply("12","456");
    }
}
