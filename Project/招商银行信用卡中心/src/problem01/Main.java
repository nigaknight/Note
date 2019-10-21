package problem01;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/15
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int n=s.length();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            if (s.charAt(i)=='R'){
                int j=i+1;
                while (j<=n-1&&s.charAt(j)!='L'){
                    j++;
                }
                int juli=j-i;
                if (juli%2==0){
                    nums[j]++;
                }else {
                    nums[j-1]++;
                }
            } else {
                int j=i-1;
                while (j>=0&&s.charAt(j)!='R'){
                    j--;
                }
                int juli=i-j;
                if (juli%2==0){
                    nums[j]++;
                } else {
                    nums[j+1]++;
                }
            }
        }
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
