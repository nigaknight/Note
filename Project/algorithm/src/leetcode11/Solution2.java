package leetcode11;

/**
 * @author nigaknight
 * @time 2019/9/29
 **/
public class Solution2 {
    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int temp=(right-left)*Math.min(height[right],height[left]);
            if (temp>max){
                max=temp;
            }
            if (height[right]>height[left]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
