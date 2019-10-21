package problem03.extend;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/17
 * 小米
 * https://www.nowcoder.com/question/next?pid=15226084&qid=325925&tid=27661176
 * [编程题]找出单向链表中的一个节点，该节点到尾指针的距离为K
 * 时间限制：1秒
 *
 * 空间限制：65536K
 *
 * 找出单向链表中的一个节点，该节点到尾指针的距离为K。链表的倒数第0个结点为链表的尾指针。要求时间复杂度为O(n)。
 * 链表结点定义如下：
 * struct ListNode
 * {
 *     int m_nKey;
 *     ListNode* m_pNext;
 * }
 * 链表节点的值初始化为1，2，3，4，5，6，7。
 *
 * 输入描述:
 * 该节点到尾指针的距离K
 *
 * 输出描述:
 * 返回该单向链表的倒数第K个节点，输出节点的值
 *
 * 输入例子1:
 * 2
 *
 * 输出例子1:
 * 6
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int[] nums={1,2,3,4,5,6,7};
        ListNode head=new ListNode(nums[0]);
        ListNode p=head;
        for (int i=1;i<nums.length;i++){
            p.next=new ListNode(nums[i]);
            p=p.next;
        }
        ListNode node1=head;
        ListNode node2=head;
        while (k>0){
            node1=node1.next;
            k--;
        }
        while (node1!=null){
            node1=node1.next;
            node2=node2.next;
        }
        System.out.println(node2.val);
    }
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val=val;
        }
    }
}
