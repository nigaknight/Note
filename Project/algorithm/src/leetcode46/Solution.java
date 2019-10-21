package leetcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/11
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 参数：数组nums，结果list，已经使用过的元素标记数组isused[i]
 * 出口：长度为0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> res = new Solution().permute(nums);
        System.out.println(res);
    }
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    private void backtrace(int[] nums,List<Integer> list,boolean[] isVisited){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!isVisited[i]){
                list.add(nums[i]);
                isVisited[i]=true;
                backtrace(nums,list,isVisited);
                list.remove(list.size()-1);
                isVisited[i]=false;
            }
        }
    }
}
