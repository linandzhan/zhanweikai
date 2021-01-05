package tree;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的层序遍历。用queue队列实现。
 * 一层放入一个队列中，再取出来放到List
 */
public class TreeCeng {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }

                list.add(node.val);
                size--;
            }
            res.add(list);
        }
        return res;
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

        TreeNode rightl = new TreeNode();
        rightl.val = 60;
        right.left = rightl;

        List<List<Integer>> lists = levelOrder(root);

        System.out.println(lists);



    }






}


