package 链表;

/**
 * 合并两个链表(升序的链表）
 */
public class HeBingLianBiao {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);  //作为虚拟头节点
        ListNode prev = prehead;  //移动节点
        while(l1 != null && l2 != null) {  //只要有一个链表接完就跳出来
            if(l1.val > l2.val){
                //遵循升序规则
                prev.next = l2;  //接到L2
                l2 = l2.next;
            }else {
                prev.next = l1;
                l1 = l1.next;
            }

            prev = prev.next;
        }

        //一定会存在有一个链表没有拼接完
        prev.next = l1==null?l2:l1;  //l1为null，则拼l2

        return  prehead;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        root.next = l1;
        l1.next = l2;
        l2.next = l3;


        ListNode root2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        root2.next = l21;
        l21.next = l22;

        ListNode listNode = mergeTwoLists(root, root2);
        System.out.println(listNode);
    }
}
