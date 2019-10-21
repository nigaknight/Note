package problem03.origin;

import java.util.ArrayList;

/**
 * @author nigaknight
 * @time 2019/9/17
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 **/
public class Main {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if (listNode==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> temp = printListFromTailToHead(listNode.next);
        ArrayList<Integer> list = new ArrayList<>(temp);
        list.add(listNode.val);
        return new ArrayList<>(list);
    }
}
