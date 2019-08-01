package problem01;

import java.util.HashMap;
import java.util.Stack;

/*
 * @author nigaknight
 * @time 2019/8/1
 */
public class Solution02 {
    public boolean isValid(String s) {
        //使用HashMap来简化解决方法
        HashMap<Character,Character> map=new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsValue(c)){
                stack.push(c);
            }
            else if(map.containsKey(c)){
                if(!stack.isEmpty()&&stack.peek()==map.get(c)){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
