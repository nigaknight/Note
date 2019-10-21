package leetcode60;

/**
 * @author nigaknight
 * @time 2019/9/12
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 参数：n，k，排列结果s,是否使用过的标记boolean数组
 **/
public class Solution {
    int count=0;
    String res="";
    public String getPermutation(int n, int k) {
        backtrace(n,k,new StringBuilder(),new boolean[n+1]);
        return res;
    }
    public void backtrace(int n,int k,StringBuilder s,boolean[] isused){
        if (s.length()==n){
            count++;
            if (count==k){
                res=s.toString();
            }
            return;
        }
        for (int i=1;i<=n;i++){
            if (isused[i]){
                continue;
            }
            s.append(i);
            isused[i]=true;
            backtrace(n,k,s,isused);
            s.deleteCharAt(s.length()-1);
            isused[i]=false;
        }
    }
}
