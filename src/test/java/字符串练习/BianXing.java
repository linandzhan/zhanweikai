package 字符串练习;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变型(用二维数组存储）
 */
public class BianXing {
    public static String convert(String s, int numRows) throws Exception {


        char[][] result = new char[numRows][15];
        boolean flag = true;
        int i=0,j=0,length=0;
        while(length<s.length()) {
            if(flag) {
                result[i++][j] = s.charAt(length++);
            }else{
                result[--i][++j] = s.charAt(length++);  //i从2变到1了,实际存储【1，1】
            }
            if(i==numRows){   //i为3了 实际存到2，要反弹

                flag = !flag;
                i--;   //向上移动一位。i从3变为2
            }
            if(i==0){
                flag = !flag;  //0存完就++
                i++;   //因为此时0已经存过了，要向下移动一位从1开始
            }

        }
        List<Character> list = new ArrayList<>();
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < result[k].length; l++) {
                if(result[k][l] !=  0) {
                    list.add(result[k][l]);
                }
            }
        }

        System.out.println(list);


        return null;
    }

    public static void main(String[] args) throws Exception {
        convert("LEETCODEISHIRING",3);
    }
}






class Solution1 {
    public String convert(String s, int numRows) {


        return null;
    }
}

//
//    int  b[][]={{1}, {2,2}, {2,2,2}};
//
//    int sum=0;
//
//for(int i=0;i<b.length;i++) {
//
//        for(int j=0;j<b[i].length;j++) {
//
//        sum+=b[i][j];
//
//        }
//
//        }





