package 链表;

/**
 * 复习链表的题目
 *
 */
public class FuXi {

    /**
     * 两个升序的链表合并成一个升序的链表
     */
    public static ListNode hebing(ListNode node1,ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while(node1!=null && node2 !=null) {
            if(node1.val > node2.val) {
                prev.next = node2;
                node2 = node2.next;
            }else {
                prev.next = node1;
                node1 = node1.next;
            }

            prev = prev.next;
        }

        prev.next = node1==null ? node2 : node1;

        return head.next;
    }


    /**
     * 单链表反转  1-》2—》3-》4     4-》3-》2-》1
     * 思路：用两个指针后面的指向前面的，以此遍历下去
     */
    public static ListNode revers(ListNode node) {
        ListNode pre  = null;  //一开始 node.next = pre   第一个节点指向null表名为最后一个节点
        ListNode cur = node;

        while(cur != null) {
            ListNode temp = cur.next;  //临时存放，因为cur.next即将要发生改变
            cur.next = pre;
            pre = cur;  //上一行当前指针的next已经发生改变，则可以将Pre转移到当前指针
            cur = temp;  //cur的next已经改变，则cur转移到下一个节点，下一个节点则给刚刚的temp临时存放着
        }


        return  pre;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(1);
            ListNode l3 = new ListNode(7);
        root.next = l1;
        l1.next = l2;
            l2.next = l3;

        ListNode revers = revers(root);
        while(revers != null) {
            System.out.println(revers);
            revers = revers.next;
        }

    }
}
