package 招银科技.problem02;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/6
 **/
public class Main {
    private static int count;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        dfs(0,0,n);
        System.out.println(count);
    }

    public static void dfs(int b,int c,int n){
        if(b > 2 || c > 1) return;
        if(n==0){
            count++;
            return;
        }
        dfs(0,c,n-1);
        dfs(b+1,c,n-1);
        dfs(0,c+1,n-1);
    }
}
