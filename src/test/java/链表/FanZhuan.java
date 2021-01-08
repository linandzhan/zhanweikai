package 链表;

/**
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class FanZhuan {
    public static ListNode reverseList(ListNode head) {
        //两个节点移动，一个在前一个在后 。移动一位，前面的指一下后面的。
        //用两个临时节点，一个是用来存储当前指针，一个用来改变指向的节点
        ListNode cur = head;
        ListNode pre = null;

        while(cur != null) {
            //cur不断地向后移动的
            ListNode next = cur.next;   //获取下一个节点,保存起来
            //获取完之后，可以将指向改变
            cur.next = pre;  //指向改变成pre，即指到前一个位置去
            pre = cur;  //为下一次循环的指向改变做准备。cur利用完了之后要进行移动了
            cur = next;  //进入下一次循环，一样操作
        }


        return pre;   //返回最前的指向
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(7);
        root.next = l1;
        l1.next = l2;
        l2.next = l3;

        ListNode listNode = reverseList(root);
        System.out.println(listNode);
    }
}
