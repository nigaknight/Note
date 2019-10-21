package mihayo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/10/10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        int count=0;
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
            count++;
        }
        boolean res = helper(nums, n);
        if (res){
            System.out.println("YES+"+count);
        }else {
            System.out.println("NO+"+count);
        }
    }
    public static boolean helper(int[] nums,int n){
        List<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (nums[i]==0){
                continue;
            }
            if (list.contains(nums[i])){
                return false;
            } else {
                list.add(nums[i]);
            }
            if (nums[i]>max){
                max=nums[i];
            }
            if (nums[i]<min){
                min=nums[i];
            }
        }
        if (max-min<n){
            return true;
        }
        return false;
    }
}
