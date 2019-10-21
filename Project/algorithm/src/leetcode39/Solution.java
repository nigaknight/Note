package leetcode39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/11
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 回溯法：
 * 返回的结果：一个包含和为target的list的list
 * 回溯的参数：和为target的list，candidates数组，减去前面元素的target，回溯时访问的元素的下标（为了去重）
 * 回溯的出口：target为0
 * 递归条件：直接递归，递归完成后减去list的最后一个元素
 *
 * list添加到结果的时候一定要重新new一个list
 * 这里循环的时候要添加访问到的元素的下标，进行去重
 **/
public class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(new ArrayList<>(),candidates,target,0);
        return res;
    }
    public void backtrace(List<Integer> list,int[] candidates,int target,int start){
        if (target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target<0){
            return;
        }
        for (int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            backtrace(list,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}
