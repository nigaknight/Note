package leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/12
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 参数：数组nums，子集元素个数n，遍历的位置start，组合结果list
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        new Solution().subsets(nums);
    }
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int i=0;i<=nums.length;i++){
            backtrace(nums,i,0,new ArrayList<>());
        }
        return res;
    }
    public void backtrace(int[] nums, int n, int start, ArrayList<Integer> list){
        if (n==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<nums.length;i++){
            list.add(nums[i]);
            System.out.println(list);
            backtrace(nums,n-1,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
