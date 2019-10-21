package binarysearch;

/**
 * @author nigaknight
 * @time 2019/9/7
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=preSearch(nums,target);
        res[1]=endSearch(nums,target);
        return res;
    }
    public int preSearch(int[] nums,int target){
        int l=0;
        int r=nums.length;
        boolean found=false;
        while (l<r){
            int m=l+(r-l)/2;
            if(target==nums[m]){
                r=m;
                found=true;
            } else if(target>nums[m]){
                l=m+1;
            } else if(target<nums[m]){
                r=m;
            }
        }
        return found?l:-1;
    }
    public int endSearch(int[] nums,int target){
        int l=0;
        int r= nums.length;
        boolean found=false;
        while (l<r){
            int m=l+(r-l)/2;
            if(target==nums[m]){
                l=m+1;
                found=true;
            } else if(target>nums[m]){
                l=m+1;
            } else if(target<nums[m]){
                r=m;
            }
        }
        return found?l-1:-1;
    }
}
