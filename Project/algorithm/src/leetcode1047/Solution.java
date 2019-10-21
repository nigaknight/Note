package leetcode1047;

import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<S.length();i++){
            if (!stack.isEmpty()&&stack.peek()==S.charAt(i)){
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
