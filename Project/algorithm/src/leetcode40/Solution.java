package leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/11
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  回溯参数：candidates数组，和为target的list，减去当前list和的target，遍历到的下标start
 **/
public class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates,new ArrayList<>(),target,0);
        return res;
    }
    public void backtrace(int[] candidates,ArrayList<Integer> list,int target,int start){
        if (target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target<0){
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            backtrace(candidates,list,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
