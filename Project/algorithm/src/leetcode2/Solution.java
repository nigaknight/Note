package leetcode2;

/**
 * @author nigaknight
 * @time 2019/10/1
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        int carry=0;
        while (l1!=null&&l2!=null){
            int sum=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            head.next=new ListNode(sum);
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int sum=(l1.val+carry)%10;
            carry=(l1.val+carry)/10;
            head.next=new ListNode(sum);
            l1=l1.next;
            head=head.next;
        }
        while (l2!=null){
            int sum=(l2.val+carry)%10;
            carry=(l2.val+carry)/10;
            head.next=new ListNode(sum);
            l2=l2.next;
            head=head.next;
        }
        if (carry!=0){
            head.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
