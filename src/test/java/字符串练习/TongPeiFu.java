package 字符串练习;

public class TongPeiFu {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
            int j = ps.length;
            for (int i= ss.length; i >= 0; i--) {
                if(ps[j] != '*' || ps[j] != '?') {
                    if(ss[i] == ps[j]) {
                        j--;
                    }
                }else if(ps[j] == '*') {
                    while(!(ss[i-1] == ps[j-1] || ps[i-1] == '?')) {
                        continue;
                    }
                    if (i-1 == j-1 & i-1 == 0) {

                    }

                }



            }

        return false;
    }
}
