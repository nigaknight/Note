package leetcode19;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1=head;
        ListNode l2=head;
        int k=n;
        while (k-->0){
            l1=l1.next;
        }
        ListNode prev=head;
        while (l1!=null){
            l1=l1.next;
            l2=l2.next;
            if (l1!=null&&l1.next==null){
                prev=l2;
            }
        }
        if (l2==head){
            head=l2.next;
        } else {
            prev.next=l2.next;
        }
        return head;
    }
}
