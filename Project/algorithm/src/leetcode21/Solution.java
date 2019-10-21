package leetcode21;

/**
 * @author nigaknight
 * @time 2019/10/1
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        while (l1!=null&&l2!=null){
            int val;
            if (l1.val<l2.val){
                val=l1.val;
                l1=l1.next;
            } else {
                val=l2.val;
                l2=l2.next;
            }
            head.next=new ListNode(val);
            head=head.next;
        }
        if (l1!=null){
            head.next=l1;
        }
        if (l2!=null){
            head.next=l2;
        }
        return dummy.next;
    }
}
