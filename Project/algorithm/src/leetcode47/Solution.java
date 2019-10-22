package leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/11
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 参数：nums，list,start
 * 出口：list长度和nums相同
 * 对于这种有重复数组的数组中选，一定要先排序，去重才能生效
 **/
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrace(int[] nums, List<Integer> list, boolean[] isVisited) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            isVisited[i] = true;
            backtrace(nums, list, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}
