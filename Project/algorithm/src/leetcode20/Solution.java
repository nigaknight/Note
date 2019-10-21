package leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (!stack.isEmpty()&&map.containsKey(s.charAt(i))){
                if (stack.peek()!=map.get(s.charAt(i))){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
