package leetcode16;

import java.util.Arrays;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums={1,1,1,0};
        int i = new Solution().threeSumClosest(nums, -100);
        System.out.println(i);
    }
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int temp=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n-3;i++){
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int cha=nums[left]+nums[right]+nums[i]-target;
                if (Math.abs(cha)<min){
                    min=Math.abs(cha);
                    temp=nums[left]+nums[right]+nums[i];
                }
                if (cha<0){
                    left++;
                } else if (cha>0){
                    right--;
                } else {
                    break;
                }
            }
        }
        return temp;
    }
}
