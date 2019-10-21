package problem03;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/15
 * 参数：数组Nums，数组长度n，数组左边位置l,数组右边位置r
 * 结果：我的得分count
 **/
public class Main {
    static int count=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        backtrace(nums,n,0,n-1,0);
        System.out.println(count);
    }
    public static void backtrace(int[] nums,int n,int l,int r,int cur_count){
        if (l>=n||r<0){
            return;
        }
        if (l>r){
            count=Math.max(cur_count,count);
            return;
        }
        if (l==r){
            cur_count+=nums[l];
            count=Math.max(cur_count,count);
            return;
        }
        cur_count+=nums[l];
        backtrace(nums,n,l+1,r-1,cur_count);
        cur_count-=nums[l];
        cur_count+=nums[l];
        backtrace(nums,n,l+2,r,cur_count);
        cur_count-=nums[l];
        cur_count+=nums[r];
        backtrace(nums,n,l,r-2,cur_count);
        cur_count-=nums[r];
        cur_count+=nums[r];
        backtrace(nums,n,l+1,r-1,cur_count);
    }
}
