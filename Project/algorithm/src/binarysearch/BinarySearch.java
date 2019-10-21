package binarysearch;

/**
 * @author nigaknight
 * @time 2019/9/7
 **/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(target==nums[m]){
                return m;
            } else if(target>nums[m]){
                l=m+1;
            } else {
                r=m-1;
            }
        }
        return -1;
    }
}
