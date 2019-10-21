package problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author nigaknight
 * @time 2019/9/22
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    private static int res=Integer.MAX_VALUE;
    private static int solution(int[] input) {

        // TODO Write your code here
        backtrace(input,0,0,input.length);
        return res<input.length?res:-1;
    }
    public static void backtrace(int[] input,int count,int k,int n){
        if (k>=n-1){
            if (k==n-1&&count<res){
                res=count;
            }
            return;
        }
        for (int i=1;i<=input[k];i++){
            count++;
            backtrace(input,count,k+i,n);
            count--;
        }
    }
}
