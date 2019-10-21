package Iqiyi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/8
 **/
public class Main1 {
    static double Awin = 0;
    static double GameTimes= 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();7
        int m = scanner.nextInt();
        Helper(0,0,0,0, m, n,0,0,3);
        System.out.println(Awin);
        System.out.println(GameTimes);
        double res = Awin/GameTimes;
        System.out.println(new DecimalFormat("0.00000").format(res));

    }

    static void  Helper(int Ared, int Ablue, int Bred, int Bblue, int m, int n, int Cred, int Cblue,int last) {
        if (Ared == 1) {Awin = Awin+n+1;GameTimes = GameTimes+n+1;return;}
        if (Bred == 1) {GameTimes = GameTimes+n+1;return;}
//        else if (n == 0) {//红球用光了
//            if (Ared == 1) {//前一次A抽到红球
//                Awin++;
//                return;
//            }
//            else  return;//前一次A没抽到红球，B或者C抽到红球，A都赢不了了
//
//        }
        if (n == 0 && m == 0){GameTimes++; return;};
        if (n == 0 && m > 0) {
            if (last == 3) {
                Helper(0, 1, 0, 0, m-1, n , 0, 0,1);
            }
            else if (last == 1) {
                Helper(0, 0, 0, 1, m-1, n, 0, 0,2);
            }else if (last == 2) {
                Helper(0, 0, 0, 0, m-1, n , 0, 1,3);
            }
        }
        if (m == 0 && n > 0){//蓝球用光了，红球没用光
            if (last == 3) {
                Helper(1, 0, 0, 0, m, n - 1, 0, 0,1);
            }
            else if (last == 1) {
                Helper(0, 0, 1, 0, m, n - 1, 0, 0,2);
            }else if (last == 2) {
                Helper(0, 0, 0, 0, m, n - 1, 1, 0,3);
            }
            }
        if (m > 0 && n > 0){//蓝球红球都没用光
            if (last == 3){
                Helper(1,0,0,0,m,n-1,0,0,1);
                Helper(0,1,0,0,m-1,n,0,0,1);

            }
            else if (last == 1){
                Helper(0,0,1,0,m,n-1,0,0,2);
                Helper(0,0,0,1,m-1,n,0,0,2);
            }
            else if (last == 2) {
                Helper(0, 0, 0, 0, m, n - 1, 1, 0,3);
                Helper(0, 0, 0, 0, m - 1, n, 0, 1,3);
            }
        }

    }
}
