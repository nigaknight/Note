package YY;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/9
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        reverse(nums,0,m-1);
        reverse(nums, m, n-1);
        reverse(nums, 0, n-1);
        for (int i = 0; i < n; i++){
            System.out.println(nums[i]);
            if (i != n-1){
                System.out.println(" ");
            }
        }
    }

    public static void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j ){
        while (i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
