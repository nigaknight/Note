package leetcode43;

import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Solution {
    public String multiply(String num1, String num2) {
        int[] res=new int[110*110+2];
        for (int i=num1.length()-1;i>=0;i--){
            for (int j=num2.length()-1;j>=0;j--){
                int multi=((num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
                int index=num1.length()-1-i+num2.length()-1-j;
                res[index]+=multi;
                System.out.println(res[index]);
            }
        }
        for (int i=0;i<res.length-1;i++){
            res[i+1]+=res[i]/10;
            res[i]=res[i]%10;
        }
        Stack<Integer> stack=new Stack<>();
        for (int re : res) {
            stack.add(re);
        }
        StringBuilder sb=new StringBuilder();
        while (stack.peek()==0){
            stack.pop();
            if (stack.isEmpty()){
                return "0";
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
