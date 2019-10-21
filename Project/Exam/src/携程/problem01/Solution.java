package 携程.problem01;

/**
 * @author nigaknight
 * @time 2019/9/7
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    // 暴力深搜，使用递归的方法遍历整个数组的可能分割方案
    public static void main(String[] args) {
        int[] nums={1,2147483646};
        int m=1;
        int i = new Solution().splitArray(nums, 2);
        System.out.println("res= "+i);
    }
    private int min=Integer.MAX_VALUE;
    public int splitArray(int[] nums, int m) {
        for (int i=1;i<=nums.length;i++){
            dfs(nums,m-1,0,i, Integer.MIN_VALUE);
        }
        return min;
    }
    // 需要改变的参数为分割的位置
    public void dfs(int[] nums, int m,int pre,int length,int max){
        int sum=0;
        for (int j=0;j<length;j++){
            sum+=nums[pre+j];
        }
        System.out.println("m= "+m);
        System.out.println("sum= "+sum);
        if (sum>max){
            max=sum;
        }
        if(m==1){
            dfs(nums,m-1,pre+length,nums.length-pre-length,max);
            return;
        }
        if(m==0){
            if(max<min){
                min=max;
            }
            return;
        }
        for (int i=1;i<=nums.length-pre-length;i++){
            dfs(nums,m-1,pre+length,i,max);
        }
    }
}
