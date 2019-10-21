package YY;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/9
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        String[] list = s.split("\\->");
        int len = list.length;
        int index = 1;
        ListNode[] listNodes = new ListNode[len];
        ListNode head = new ListNode(Integer.parseInt(list[0]));
        listNodes[0] = head;
        ListNode cur = new ListNode(0);
        cur = head;
        while (index < len){
            listNodes[index] = new ListNode(Integer.parseInt(list[index]));
            cur.next= listNodes[index];
            cur = cur.next;
            index++;
        }
        if (n == len){
            while (head != null){
                if (head.next != null) {
                    head = head.next;
                    System.out.print(head.val + "->");
                }
                else System.out.print(head.val);

            }
        }
        else {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode left = dummy;
            ListNode right = head;
            for (int i = 0; i < n - 1; i++) {
                right = right.next;
            }
            while (right.next != null) {
                right = right.next;
                left = left.next;
            }
            left.next = left.next.next;
            while (dummy.next != null) {
                if (head.next != null) {
                    System.out.print(head.val + "->");
                } else System.out.print(head.val);
                head = head.next;
                dummy = dummy.next;
            }
        }


    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
