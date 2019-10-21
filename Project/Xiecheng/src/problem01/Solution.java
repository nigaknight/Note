package problem01;


/**
 * @author nigaknight
 * @time 2019/9/4
 * 给定一个单向链表和一个整数m，将链表中小于等于m的节点移到大于m的节点之前，要求两部分中的节点各自保持原有的先后顺序
 **/
public class Solution {
    static ListNode partition(ListNode head,int m) {
        ListNode l1=new ListNode(0);
        ListNode dummy1=l1;
        ListNode l2=new ListNode(0);
        ListNode dummy2=l2;
        while(head!=null){
            if(head.val<=m){
                l1.next=new ListNode(head.val);
                l1=l1.next;
            }
            else {
                l2.next=new ListNode(head.val);
                l2=l2.next;
            }
            head=head.next;
        }
        l1.next=dummy2.next;
        return dummy1.next;
    }
}
