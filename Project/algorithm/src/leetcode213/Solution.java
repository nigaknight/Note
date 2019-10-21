package leetcode213;

/**
 * @author nigaknight
 * @time 2019/10/6
 **/
public class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        int res=0;
        for (int i=0;i<n-1;i++){
            if (i==0){
                dp[i]=nums[i];
            } else if (i==1){
                dp[i]=Math.max(nums[i],nums[i-1]);
            } else {
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            res=Math.max(res,dp[i]);
        }
        for (int i=1;i<n;i++){
            if (i==1){
                dp[i]=nums[i];
            } else if (i==2){
                dp[i]=Math.max(nums[i],nums[i-1]);
            }
            else {
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            res=Math.max(res,dp[i]);
        }
        return  res;
    }
}
