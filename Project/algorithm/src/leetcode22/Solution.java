package leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/11
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 回溯法：
 * 1 输出的结果：括号字符串组成的list
 * 2 回溯方法的参数：括号字符串；还剩下的左括号数；还剩下的右括号数；
 * 3 回溯的出口：还剩下的括号数为0
 * 4 递归函数的处理过程：对于每个括号字符串，左括号数必然不小于右括号数
 **/
public class Solution {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0){
            return list;
        }
        backtrace("",n,n);
        return list;
    }
    public void backtrace(String combination,int left,int right){
        if (left==0&&right==0){
            list.add(combination);
            return;
        }
        if (left>0){
            backtrace(combination+"(",left-1,right);
        }
        if (right>0&&left<right){
            backtrace(combination+")",left,right-1);
        }
    }
}
