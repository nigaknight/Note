package leetcode23;

/**
 * @author nigaknight
 * @time 2019/10/1
 **/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int left,int right){
        if (left==right){
            return lists[left];
        }
        int mid=left+(right-left)/2;
        ListNode l1=merge(lists,left,mid);
        ListNode l2=merge(lists,mid+1,right);
        return mergeTwoLists(l1,l2);
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}
