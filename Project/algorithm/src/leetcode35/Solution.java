package leetcode35;

/**
 * @author nigaknight
 * @time 2019/10/18
 **/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if (nums[m]>target){
                r=m-1;
            } else if (nums[m]<target){
                l=m+1;
            } else {
                return m;
            }
        }
        return l;
    }
}
