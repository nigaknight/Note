package bubblesort;

/**
 * @author nigaknight
 * @time 2019/9/7
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums={1,5,4,7,453,646,24,3};
        new BubbleSort().bub(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
    public void bub(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }
}
