package 链表;

import java.util.*;

/**
 * 判断一个链表是否为回文链表
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 正读和倒读都可以
 */
public class HuiWenLianBiao {
    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        Set<Integer> set = new HashSet<>();
        while(head != null) {
            int val = head.val;
            set.add(val);    //不重复特性
            len++;
            head = head.next;
        }

        if(len%2 == 0) {
            //偶数个。
            if(set.size() == len/2) {
                return true;
            }else {
                return  false;
            }
        }else {
            if(set.size()-1 == len/2) {
                return true;
            }else {
                return  false;
            }
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
    //    ListNode l3 = new ListNode(1);
        root.next = l1;
        l1.next = l2;
        //l2.next = l3;
        boolean palindrome = isPalindrome(root);
        System.out.println(palindrome);
    }
}
