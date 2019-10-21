package leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nigaknight
 * @time 2019/9/11
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 学习回溯法的思想
 * 学习String类型的处理方法
 * 学习使用map来解决映射问题
 **/
public class Solution {
    List<String> list=new ArrayList<>();
    Map<String,String> map=new HashMap<String, String>();
    public List<String> letterCombinations(String digits) {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        if (digits.equals("")){
            return list;
        }
        backtrace("",digits);
        return list;
    }

    // 递归参数：变化量combination，表示组织后的字符串；变化量next_digits，表示还剩下的数字字符串
    public void backtrace(String combination,String next_digits){
        // 递归出口
        if(next_digits.length()==0){
            list.add(combination);
            return;
        }
        String digit=next_digits.substring(0,1);
        String characters=map.get(digit);
        // 递归
        for (int i=0;i<characters.length();i++){
            String character = characters.substring(i, i + 1);
            backtrace(combination+character,next_digits.substring(1));
        }
    }
}
