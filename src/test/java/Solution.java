import java.util.Arrays;

public class Solution {
}


class Solution1{
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == nums.length-1){
                nums[j] = nums[i];
                j++;
                return j;
            }
            while(nums[i] == nums[i+1]){
                i++;
                if(i == nums.length-1){
                    break;
                }
            }
            nums[j] = nums[i];
            j++;
        }


        return j;
    }

    public static void main(String[] args) {
        int[] ints = {3,2,3,4};
  //      int i = removeDuplicates(ints);
        int i = largestPerimeter(ints);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
        System.out.println("这是i"+i);

    }



    public static int largestPerimeter(int[] A){
        int x = 0;
        int[] result = new int[100];
//3和2组合完之后，3要和第二个3组合。
        for (int i = 0; i < A.length; i++) {
            for (int j = i+2; j<A.length;j++){
                if(A[i] + A[i+1] <= A[j] || A[i] + A[j] <= A[i+1] || A[i+1]+A[j] <= A[i]){
                    continue;
                }else {
                    result[x] = A[i] + A[i+1] + A[j];
                    x++;
                }
            }
        }
        if(x == 0){
            return 0;
        }
        Arrays.sort(result);


        return result[result.length-1];
    }



}



