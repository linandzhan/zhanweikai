package 链表;

/**
 * 两数相加 leetcode 2
 */
public class LiangShuXiangJia {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder str = new StringBuilder();
        String l1Str = getNum(l1, str);
        StringBuilder str2 = new StringBuilder();
        String l2Str = getNum(l2, str2);
        String result = String.valueOf(Integer.parseInt(l1Str) + Integer.parseInt(l2Str));
        return getNode(result);
    }

    private static ListNode getNode(String result) {
        int length = result.length();
        StringBuilder str = new StringBuilder(result);
        StringBuilder reverse = str.reverse();
        int i = Integer.parseInt(reverse.toString());


        int shou = Integer.parseInt(reverse.toString().substring(0,1));
        int shengyu = Integer.parseInt(reverse.toString().substring(1,length));
        ListNode root = new ListNode(shou);

        jianNode(root, result.length()-1, shengyu);

        return root;
    }

    private static void jianNode(ListNode root, int length, int num) {
        if(length == 0) {
            //已经添加完，直接返回
            return;
        }

        int pow = (int) Math.pow(10, length - 1);
        int val = num/pow;  //获取当前数字
        num = num%pow;  //剩余数字
        root.next = new ListNode(val);
        jianNode(root.next,--length,num);
    }


    public static String getNum(ListNode l,StringBuilder str) {
        if(l.next == null) {
            return str.append(String.valueOf(l.val)).toString();
        }else {
            getNum(l.next,str);
            str.append(String.valueOf(l.val)).toString();
        }


        return str.toString();
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
    //    ListNode l3 = new ListNode(7);
        root.next = l1;
        l1.next = l2;
    //    l2.next = l3;


        ListNode root2 = new ListNode(1);
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(3);
    //    root2.next = l21;
    //    l21.next = l22;
        ListNode listNode = addTwoNumbers(root, root2);
        System.out.println(listNode);
    }
}



   class ListNode {
     int val;
     ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       @Override
       public String toString() {
           StringBuilder str = new StringBuilder();
           str.append("val:"+val+" ");
           while(next != null) {
               str.append("val:"+next.val+" ");
               next = next.next;
           }
           return str.toString();
       }
   }

