package 字符串练习;


import java.util.Arrays;

/**
 * 找相同子串，不按顺序
 *
 * 思路：先将短的字符串进行排序，  长的字符串列举出所有可能子串
 */
public class ZhaoChongfu {

    public static int findString(String aim,String s) {

        if(aim == null || s == null ) {
            return -1;
        }

        char[] chars = aim.toCharArray();
        Arrays.sort(chars);
        String shortStr = String.valueOf(chars);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subs = s.substring(i, j+1);
//                char[] subsChar = subs.toCharArray();
//                Arrays.sort(subsChar);
//                String longStr = String.valueOf(subsChar);
                if(isTY(subs,aim)) {
                    //如果符合同源异构则返回该字串的第一位索引
                    return i;  //返回第一个位置的索引
                }
            }
        }
        return -1;
    }

    public static boolean isTY(String subs,String aim) {
        if(subs.length() != aim.length()) {
            return false;
        } //长度都不相同，直接返回false

        int[] count = new int[256];

        for (int i = 0; i < subs.length(); i++) {
            count[subs.charAt(i)]++;   //一个字母对应一个位置，统计字母出现的次数
        }

        for (int i = 0; i < aim.length(); i++) {
            if(count[aim.charAt(i)]-- == 0) {
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {
        int string = findString("fkeq", "aswekfssawsfeqfekqwiejf");
        System.out.println(string);
    }
}
