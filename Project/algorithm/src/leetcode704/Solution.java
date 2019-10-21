package leetcode704;

/**
 * @author nigaknight
 * @time 2019/10/20
 * 对于找到就return的代码来讲，找不到直接return-1即可
 **/
public class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if (target==nums[m]){
                return m;
            } else if (target<nums[m]){
                r=m-1;
            } else {
                l=m+1;
            }
        }
/*        if (l==nums.length){
            return -1;
        }
        return nums[l]==target?l:-1;*/
        return -1;
    }
}
