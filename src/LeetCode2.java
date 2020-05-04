

/**
 * @author Guangyao Gou
 * @date 2020/05/08 17:05:18
 * @ClassName LeetCode2.java
 * @Description 类描述
 */

public class LeetCode2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int i;
        ListNode l = l1;
        while (l1 != null) {
            if (l1.next == null && l2.next != null)
                l1.next = new ListNode(0);
            if (l2.next == null && l1.next != null)
                l2.next = new ListNode(0);
            
            i = l1.val + l2.val;
            if (i < 10) {
                l1.val = i;
            }
            else if (i >= 10) {
                l1.val = i - 10;
                if(l1.next != null)
                l1.next.val = l1.next.val + 1;
                else {
                    l1.next = new ListNode(1);
                    l2.next = new ListNode(0);
                }
            }
            l1 = l1.next;
            l2 = l2.next;
            
        }
 
        return l;
    }   
    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        ListNode l1 = leetCode2.new ListNode(5);
        l1.next = leetCode2.new ListNode(6);
        ListNode l2 = leetCode2.new ListNode(4);
        l2.next = leetCode2.new ListNode(8);
        ListNode l = leetCode2.addTwoNumbers(l1, l2);
        while(l!=null) {
            System.out.println(l.val);
            l=l.next;
        }    
  
    }
    
}
