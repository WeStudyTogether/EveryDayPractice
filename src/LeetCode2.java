
/**
 * @author Guangyao Gou
 * @date 2020/05/08 17:05:18
 * @ClassName LeetCode2.java
 * @Description 类描述
 */

public class LeetCode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = null;
        int i;
        while (l1 != null) {

            if ((i = l1.val + l2.val) < 10) {
                l.val = i;
            }
            if ((i = l1.val + l2.val) > 10) {
                l.val = i - 10;
                l1.next.val = l1.next.val + 1;
            }

            if (l1.next == null && l2.next != null)
                l1.next = new ListNode(0);
            if (l2.next == null && l1.next != null)
                l2.next = new ListNode(0);

            l1 = l1.next;
            l2 = l2.next;
            l = l.next;
        }
        return l;
    }   
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(8);
        ListNode l = new ListNode(0);
        l = addTwoNumbers(l1, l2);
        System.out.println(l.next.val);
            }
    
}
