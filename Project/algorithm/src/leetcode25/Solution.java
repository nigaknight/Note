package leetcode25;

/**
 * @author nigaknight
 * @time 2019/10/1
 **/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while (head!=null){
            ListNode tail=head;
            ListNode temp2=head;
            boolean flag=false;
            for (int i=0;i<k-1;i++){
                temp2=temp2.next;
                if (temp2==null){
                    flag=true;
                    break;
                }
            }
            if (flag){
                temp.next=head;
                break;
            }
            for (int i=0;i<k&&head!=null;i++){
                ListNode next=head.next;
                head.next=temp.next;
                temp.next=head;
                head=next;
            }
            temp=tail;
        }
        return dummy.next;
    }
}
