package 链表;

/**
 * 删除排序链表的重复节点。返回一个不重复节点链表0
 */
public class ShanChuChongFu {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return head;
        }
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            //有序的，只需要比较当前和下一个节点是否相同即可
            if(cur.next != null) {
                if(cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                    cur = temp.next;
                    continue;
                }
            }

            cur = temp;
        }


        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
  //      ListNode l4 = new ListNode(3);
  //      ListNode l3 = new ListNode(7);
        root.next = l1;
        l1.next = l2;
        l2.next = l3;
   //     l3.next = l4;
  //      l2.next = l3;

        ListNode revers = deleteDuplicates(root);
        while(revers != null) {
            System.out.println(revers);
            revers = revers.next;
        }
    }
}
