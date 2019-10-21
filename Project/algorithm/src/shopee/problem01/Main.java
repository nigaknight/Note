package shopee.problem01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/13
 * shopee的办公室非常大，小虾同学的位置坐落在右上角，而大门却在左下角，可以把所有位置抽象为
 * 一个网格（门口的坐标为0，0），小虾同学很聪明，每次只向上，或者向右走，因为这样最容易接近目的地，
 * 但是小虾同学不想让自己的boss们看到自己经常在他们面前出没，或者迟到被发现。
 * 他决定研究一下如果他不通过boss们的位置，他可以有多少种走法？
 *
 *
 * 输入描述:
 * 第一行 x,y,n (0<x<=30, 0<y<=30, 0<=n<= 20) 表示x,y小虾的座位坐标,n 表示boss的数量（ n <= 20）
 *
 * 接下来有n行, 表示boss们的坐标(0<xi<= x, 0<yi<=y，不会和小虾位置重合)
 *
 * x1, y1
 *
 * x2, y2
 *
 * ……
 *
 * xn, yn
 *
 * 输出描述:
 * 输出小虾有多少种走法
 *
 * 输入例子1:
 * 3 3 2
 * 1 1
 * 2 2
 *
 * 输出例子1:
 * 4
 *
 * 参数：boss[][]，x，y，当前横坐标cur_x，当前纵坐标cur_y
 **/
/*public class Main {
    static int res;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] boss=new int[x+1][y+1];
        for (int i=0;i<n;i++){
            int boss_x=scanner.nextInt();
            int boss_y=scanner.nextInt();
            boss[boss_x][boss_y]=1;
        }
        backtrace(boss,x,y,0,0);
        System.out.println(res);
    }
    public static void backtrace(int[][] boss,int x,int y,int cur_x,int cur_y){
        if (cur_x==x&&cur_y==y){
            res++;
            return;
        }
        if (cur_x+1<=x&&(boss[cur_x+1][cur_y]!=1)){
            backtrace(boss,x,y,cur_x+1,cur_y);
        }
        if (cur_y+1<=y&&(boss[cur_x][cur_y+1]!=1)){
            backtrace(boss,x,y,cur_x,cur_y+1);
        }
    }
}*/

/*
* 动态规划
* dp[i][j]为位置在i,j的时候的走法
* dp[i][j]=dp[i-1][j]+dp[i][j-1]
* */

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int n=scanner.nextInt();
        long[][] dp=new long[x+1][y+1];
        for (int i=0;i<=x;i++){
            Arrays.fill(dp[i],1);
        }
        for (int i=0;i<n;i++){
            int boss_x=scanner.nextInt();
            int boss_y=scanner.nextInt();
            dp[boss_x][boss_y]=-1;
        }
        for (int i=1;i<=x;i++){
            for (int j=1;j<=y;j++){
                if (dp[i][j]==-1){
                    continue;
                }
                dp[i][j]=(dp[i-1][j]==-1?0:dp[i-1][j])+(dp[i][j-1]==-1?0:dp[i][j-1]);
            }
        }
        System.out.println(dp[x][y]);
    }
}
