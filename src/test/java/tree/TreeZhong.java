package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 树的中序遍历
 */
public class TreeZhong {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    public static void inorder(TreeNode root,List<Integer> tree) {
        if(root.left != null) {
            inorder(root.left,tree);
        }
        tree.add(root.val);
        if(root.right != null) {
            inorder(root.right,tree);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 10;
        TreeNode left = new TreeNode();
        left.val = 20;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 30;
        root.right = right;

        TreeNode leftr = new TreeNode();
        leftr.val = 40;
        left.right = leftr;



        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);


    }
}




 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }
