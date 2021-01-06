package 字符串练习;

import java.util.HashSet;
import java.util.Set;

public class StringNoRepeat {
    public static int lengthOfLongestSubstring(String s) {
        if(s == "") {
            return 1;
        }
        Set set = new HashSet<Character>();
        int length = 0;
        for(int i=0;i<s.length();i++) {
//            set.add(s.charAt(i));
            for(int j=i;j<s.length();j++) {
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }else {
                    if(length < set.size()){
                        length = set.size();
                    }
                    set.clear();
                    break;
                }
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int l = lengthOfLongestSubstring("");
        System.out.println(l);
    }
}

/**
 * 无重复字符最长子串
 */
class StringNoRepeat1{
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < chars.length-1; i++) {
            set.add(chars[i]);
            for (int j = i+1; j < chars.length; j++) {
                if (set.contains(chars[j])) {
                    length = set.size();
                    max = Math.max(max, length);
                    set.clear();
                    break;
                }
                set.add(chars[j]);


            }
        }

        return max;
    }

    public static void main(String[] args) {
        int l = lengthOfLongestSubstring("ppplllkjhgfjjkkiuuiytghjk");
        System.out.println(l);
    }
}
