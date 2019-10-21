package problem03.origin;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/9/17
 **/
public class Main02 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
