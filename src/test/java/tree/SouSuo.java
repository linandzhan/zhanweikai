package tree;

/**
 * 搜索树，左边一定小于头节点，右边一定大于头节点
 * 搜索二叉树的后续遍历   （给我一个搜索二叉树后续遍历数组，建树，并返回头节点）
 */
public class SouSuo {
    public static TreeNode getHead(int[] arr) {
        TreeNode head = jianshu(arr, 0, arr.length - 1);


        return head;
    }


    public static TreeNode jianshu(int[] arr,int l,int r) {
        TreeNode head = new TreeNode(arr[r]);
        if(l == r) {
            return head;
        }
        int m = -1;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[r]) {
                m = i;   //每次这个数小于头节点的，都记录一次，到后面记录到循环结束为止
            }
        }




        //不存在左节点
        if(m == -1) {
            head.left = null;
            head.right = jianshu(arr,0,r-1);
        }

        //存在左节点
        if(m != -1) {
            //则证明有左节点
            if(m == r-1) {
                //证明没有右节点，只有左节点
                head.right = null;
            }else {
                head.right = jianshu(arr,m+1,r-1);   //建右树
            }
            head.left = jianshu(arr,l,m);
        }

        return head;


    }

    public static void main(String[] args) {
        int[] arr = {6,10,9,8,5};
        TreeNode head = getHead(arr);

        System.out.println(head.right.left);
    }
}



