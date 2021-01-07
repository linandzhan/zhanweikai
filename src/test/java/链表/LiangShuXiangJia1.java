package 链表;

/**
 * 两个链表的数相加
 */
public class LiangShuXiangJia1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,tail =null;
        int carry = 0;
        //遍历两个链表
        while(l1!=null || l2!=null) {

            int num1 = l1!=null ? l1.val:0;  //当前节点如果为null就取0
            int num2 = l2!=null ? l2.val:0;
            int sum = num1 + num2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum%10);  //取个位数
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;    //临时链表的威力
            }

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }


            carry = sum/10;  //取十位数
        }

        if(carry != 0) {
            tail.next = new ListNode(carry);
        }


        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
            ListNode l3 = new ListNode(7);
        root.next = l1;
        l1.next = l2;
            l2.next = l3;


        ListNode root2 = new ListNode(1);
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(3);
            root2.next = l21;
            l21.next = l22;
        ListNode listNode = addTwoNumbers(root, root2);
        System.out.println(listNode);
    }
}

/**
 * 就是利用每个节点互相加，有余数记录下来，留给下一个相加的，最后余数还存在，就开一个新的节点拼上去
 *输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
