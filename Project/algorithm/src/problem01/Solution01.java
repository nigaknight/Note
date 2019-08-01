package problem01;

import java.util.Stack;

/**
 *  @author nigaknight
 *  @since 2019/8/1 22:04
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class Solution01 {
    public boolean isValid(String s) {
        // 如果出现左边的括号，压入栈中；如果出现右边的括号，则判断栈顶是否是对应的左边括号，如果是，则栈顶出栈，如果不是，则返回false
        // 如果遍历到最后，栈为空，则返回true
        // 先建立一个栈
        // 遍历字符串
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }
            else if(c==')'){
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(c==']'){
                if(!stack.isEmpty()&&stack.peek()=='['){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if(c=='}'){
                if (!stack.isEmpty()&&stack.peek()=='{'){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

