package 字符串练习;

import java.util.*;

public class LuoMa {

    public static String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");


        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.sort(list);





        StringBuilder str = new StringBuilder();
        int sheng = num;
        if(!set.contains(num) && !(num == 4 || num == 40 || num == 400) && !((num == 9 || num == 90 || num == 900))) {
            while (sheng > 1000) {
                sheng = sheng - list.get(list.size()-1);
                str.append(map.get(1000));
            }

            for (int i = list.size()-1; i >= 1; i--) {
                while (list.get(i) > sheng  && list.get(i-1) < sheng) {

                    sheng = sheng - list.get(i-1);
                    str.append(map.get(list.get(i - 1)));
                }
                if((sheng == 4 || sheng == 40 || sheng == 400) || ((sheng == 9 || sheng == 90 || sheng == 900))) {
                    break;
                }
            }


        }




        if(set.contains(sheng)) {
            str.append(map.get(sheng));
            return str.toString(); //如果命中了上面这几个数字
        }



            return null;


        }







    public static void main(String[] args) {
        String s = intToRoman(1994);
        System.out.println(s);
    }
}
