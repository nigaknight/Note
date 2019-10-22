package leetcode34;

/**
 * @author nigaknight
 * @time 2019/10/20
 * 二分查找边界比较难把握，但是如果要找边界值，应该用l<r，而不是l<=r
 * 不管怎么样，l=m和r=m+1是不变的
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = leftSearch(nums, target);
        res[1] = rightSearch(nums, target);
        return res;
    }

    private int leftSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        boolean found = false;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                r = m;
                found = true;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return found ? l : -1;
    }

    private int rightSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        boolean found = false;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                l = m + 1;
                found = true;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return found ? l - 1 : -1;
    }
}
