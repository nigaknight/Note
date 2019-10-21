package problem01;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder string=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!='['&&s.charAt(i)!=']'){
                string.append(s.charAt(i));
            }
        }
        String[] nums = string.toString().split(",");
/*        for (String num:nums){
            System.out.println(num);
        }*/
        Integer[] array=new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            array[i]=Integer.valueOf(nums[i].trim());
        }
        int helper = helper(array);
        System.out.println(helper);
    }

    public static int helper(Integer[] array){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
            if (sum>max){
                max=sum;
            }
            if (sum<0){
                sum=0;
            }
        }
        return max;
    }
}
