package leetcode232;

import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
class MyQueue {
    Stack<Integer> stackpop=new Stack<>();
    Stack<Integer> stackpush=new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stackpop.isEmpty()){
            stackpush.push(stackpop.pop());
        }
        stackpush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stackpush.isEmpty()){
            stackpop.push(stackpush.pop());
        }
        return stackpop.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stackpush.isEmpty()){
            stackpop.push(stackpush.pop());
        }
        return stackpop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackpop.isEmpty()&&stackpush.isEmpty();
    }
}
