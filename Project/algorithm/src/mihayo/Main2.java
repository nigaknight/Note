package mihayo;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/10/10
 **/
public class Main2 {
    static int rows;
    static int cols;
    static int count=1;
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int R=scanner.nextInt();
        int C=scanner.nextInt();
        rows=R;
        cols=C;
        char[][] str=new char[R][C];
        String[] temp=new String[R];
        for (int i=0;i<R;i++){
            temp[i]=scanner.next();
            for (int j=0;j<C;j++){
                str[i][j]=temp[i].charAt(j);
            }
        }
        int r1=scanner.nextInt();
        int c1=scanner.nextInt();
        int r2=scanner.nextInt();
        int c2=scanner.nextInt();
        char temp2=str[r1][c1];
        str[r1][c1]=str[r2][c2];
        str[r2][c2]=temp2;
        boolean[][] marked=new boolean[R][C];
        dfs(str,r1,c1,marked,0);
        dfs(str,r2,c2,marked,0);
        System.out.println(count);
    }
    public static void dfs(char[][] grid,int i,int j,boolean[][] marked,int num){
        if (num >= 3) {
            count+=num;
        }
        marked[i][j]=true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == grid[i][j] && !marked[newX][newY]) {
                dfs(grid,newX, newY,marked,num+1);
            }
        }
    }
    private static boolean inArea(int x,int y){
        return x>=0&&x<rows&&y>=0&&y<cols;
    }
}
