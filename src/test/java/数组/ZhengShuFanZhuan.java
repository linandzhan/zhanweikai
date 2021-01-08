package 数组;

/**
 * 整数反转
 * 输入: 123
 * 输出: 321
 */
public class ZhengShuFanZhuan {
    public static int reverse(int x) {
        StringBuilder str = new StringBuilder();
        int num = Math.abs(x);
        if(x < 0 ){
            str.append("-");
        }
        if(x == 0) {
            str.append(0);
        }
        while(num != 0) {
            int i = num % 10;
            num = num /10;
            str.append(i);
        }

        int result = Integer.parseInt(str.toString());


        return result;
    }

    public static int reverse1(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            //先比较倒数第二位大小，如果倒数第二位相同，再比较最后一位的大小
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int reverse = reverse1(1534236469);
        System.out.println(reverse);
    }
}
