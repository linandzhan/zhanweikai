package 字符串练习;

/**
 * 搜索旋转数组
 */

public class XuanZhuan {
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] a  = {2,4,1,7,9};
        int search = search(a, 7);
        System.out.println(search);
    }
}
