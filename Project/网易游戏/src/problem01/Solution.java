package problem01;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/7
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums=new int[n];
        int i=0;
        while(scanner.hasNextInt()){
            nums[i]=scanner.nextInt();
            i++;
        }
        String[] strings=new String[n];
        for (int j=0;j<n;j++){
            System.out.println(nums[j]);
            strings[j]=Integer.toBinaryString(nums[j]);
            System.out.println(strings[j]);
            boolean res=isHuiwen(strings[j]);
            if(res){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean isHuiwen(String s){
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
