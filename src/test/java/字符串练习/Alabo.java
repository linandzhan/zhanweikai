package 字符串练习;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Alabo {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        int i = 0;
        int count = 0;
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");

        Set<Integer> set = map.keySet();
        if(set.contains(num)) {
            return map.get(num);
        }
        if(num > 10) {
            while(num < i) {
                i = i+10;
                count++;
                if(num == i) {
                    for (int j = 0; j < count; j++) {
                        str.append(map.get(10));
                    }
                    return str.toString();
                }
            }

        }

        if(num < 10) {
            if(num == 9) {
                return map.get(1)+map.get(10);
            }

        }

        if(1<= num && num <4) {
            while(i != num) {
                i++;
            }
            for (int j = 0; j < i; j++) {
                str.append(map.get(1));
            }
        }

        if(num > 5 && num<=10) {


        }




        return null;
    }
}
