package problem02;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/15
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] nums=new int[n][2];
        for (int i=0;i<n;i++){
            nums[i][0]=scanner.nextInt();
            nums[i][1]=scanner.nextInt();
        }
        int completeTime=nums[0][0];
        int numOfFold=0;
        for (int i=0;i<n;i++){
            if (i==0){
                numOfFold=nums[i][1];
                continue;
            }
            int temp=numOfFold;
            int timeCha=Math.max(0,numOfFold-(nums[i][0]-nums[i-1][0]));
            numOfFold=timeCha+nums[i][1];
            if (nums[i][0]<temp+nums[i-1][0]){
                completeTime=numOfFold+nums[i][0];
            } else {
                completeTime=nums[i][0]+nums[i][1];
            }
        }
        System.out.print(completeTime+" "+numOfFold);
    }
}
