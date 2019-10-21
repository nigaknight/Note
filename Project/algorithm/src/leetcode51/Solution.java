package leetcode51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/12
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 最后的输出是图形化的棋盘，但是可以抽象为每行棋子所在的列的数字的组合
 * 比如四皇后的第一个解对应[2,4,1,3]
 * 实际相当于N个数全排列后，取满足要求的排列
 * N皇后的回溯条件是：主要关注对角线的情况
 * 参数:n,排列list,是否使用过的数组isused[n],递归次数k,主对角线是否能放lup，副对角线是否能放rup
 **/
public class Solution {
    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
    List<List<Integer>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        backtrace(n,new ArrayList<>(),new boolean[n+1],new boolean[2*(n+1)],new boolean[2*(n+1)]);
        List<List<String>> print=new ArrayList<>();
        for (int i=0;i<res.size();i++){
            List<String> list=new ArrayList<>();
            for (int j=0;j<res.get(i).size();j++){
                int temp=res.get(i).get(j);
                list.add(printQ(n,temp));
            }
            print.add(new ArrayList<>(list));
        }
        return print;
    }
    public void backtrace(int n, ArrayList<Integer> list,boolean[] isused,boolean[] lup,boolean[] rup){
        if (list.size()==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=1;i<=n;i++){
            if (isused[i]||lup[list.size()+i+1]||rup[n+list.size()-i+1]){
                continue;
            }
            list.add(i);
            System.out.println(list);
            isused[i]=true;
            lup[list.size()+i]=true;
            rup[n+list.size()-i]=true;
            backtrace(n,list,isused,lup,rup);
            list.remove(list.size()-1);
            isused[i]=false;
            lup[list.size()+i]=false;
            rup[n+list.size()-i]=false;
        }
    }
    public String printQ(int n,int m){
        StringBuilder sb=new StringBuilder();
        for (int i=1;i<=n;i++){
            if (i==m){
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
