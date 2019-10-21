package problem01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/15
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        Arrays.sort(nums);
        int count=0;
        for (int i=0;i<=n-2;i++){
            int target=k-nums[i];
            int r=n-1;
            for (int l=i+1;l<=n-3;l++){
                while (r>l&&nums[l]+nums[r]>=target){
                    r--;
                }
                if (r>l&&nums[l]+nums[r]<target){
                    count+=r-l;
                }
            }
        }
        System.out.println(count);
    }
}
