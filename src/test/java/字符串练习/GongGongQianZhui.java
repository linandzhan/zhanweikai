package 字符串练习;

/**
 * 找出字符串数组的最长公共前缀
 */
public class GongGongQianZhui {

    //aasss aaaww aaaff          wertweq  wertqws  wertuyt
    public static String longestCommonPrefix(String[] strs) {
        char[][] arr = new char[strs.length][200];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                arr[i][j] = strs[i].charAt(j);
            }
        }

        StringBuilder str = new StringBuilder();
        int count = 0;
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < arr.length; i++) {
               if(arr[i][count] == arr[i+1][count]) {
                   if(i == arr.length-2) {
                       str.append(arr[i][count]);
                       count++;  //已经有公共部分了
                       break;   //退出当前循环，进入下一个的比较
                   }
                   continue;
               }else {
                   return str.toString();
               }

            }
        }


        return str.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"three","the","that"};
        String s = longestCommonPrefix(arr);
        System.out.println(s);
    }
}
