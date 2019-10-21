package leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0;i<=n-4;i++){
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j=i+1;j<=n-3;j++){
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                while (left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum<target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
