package leetcode70;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/12
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 参数：n，k，组合list，遍历到的位置start
 **/
public class Solution {
    public static void main(String[] args) {
        combine(4,2);
    }
    static List<List<Integer>> res=new ArrayList<>();
    static public List<List<Integer>> combine(int n, int k) {
        backtrace(n,k,new ArrayList<>(),1);
        return res;
    }
    static public void backtrace(int n, int k, ArrayList<Integer> list,int start){
        if (k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<=n;i++){
            list.add(i);
            backtrace(n,k-1,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
