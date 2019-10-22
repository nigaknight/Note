package leetcode283;

/**
 * @author nigaknight
 * @time 2019/10/22
 **/
public class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
