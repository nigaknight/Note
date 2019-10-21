package problem02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/9/4
 * 豚厂给自研的数据库设计了一套查询表达式，在这个表达式中括号表示将里面的字符串翻转。请你帮助实现这一逻辑
 * 输入
 * 一行字符串
 *
 * 输出
 * 一行字符串
 *
 * 如果表达式括号不匹配，输出空字符串
 *
 *
 * 样例输入
 * ((ur)oi)
 * 样例输出
 * iour
 **/
public class Solution {
    // 用栈保存字符串
    static Stack<Character> stack=new Stack<>();
    static Queue<Character> queue=new LinkedList<>();
    static String resolve(String expr) {
        // 遇到右括号弹出，直到弹出左括号
        // 将弹出的字符保存起来，然后翻转，压入到队列中
        for(int i=0;i<expr.length();i++){
            stack.push(expr.charAt(i));
            if(stack.peek()==')'){
                stack.pop();
                while (!stack.isEmpty()&&stack.peek()!='('){
                    queue.add(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()){
                    stack.push(queue.poll());
                }
            }
        }
        StringBuilder s=new StringBuilder();
        while (!stack.isEmpty()){
            if(stack.peek()=='('||stack.peek()==')'){
                return "";
            }
            s.append(stack.pop());
        }
        return s.reverse().toString();
    }
}
