package 字符串练习;



import java.util.HashMap;

public class YouXiaoKuoHao {
    public static boolean isValid(String s) {
        if(!s.contains(")") && !s.contains("}") && !s.contains("]")) {
            return false;
        }
        HashMap<Integer,Character> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)+1 == s.charAt(j) || s.charAt(i)+2  == s.charAt(j)) {
                    //对称的就过
                    if(i+2 == s.length()) {
                        return true;
                    }
                    i++;
                    j++;
                    break;
                }else {
                    if(s.charAt(j) !=')' && s.charAt(j) != '}' && s.charAt(j) != ']') {
                        len++;
                        map.put(len,s.charAt(j-1));  //记录个数，存起来
                    }else {
                        for (int k = len; k >0 ; k--) {
                            if(map.get(k) + 1 != s.charAt(j) && map.get(k)+2 != s.charAt(j) && map.get(k)+2 != s.charAt(j)) {
                                return false;
                            }
                        }
                    }



                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        boolean valid = isValid("[]((}");
        System.out.println(valid);
    }
}
