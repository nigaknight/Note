package problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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
    static int res=0;
    private static int solution(int[] input) {

        // TODO Write your code here
        Arrays.sort(input);
        int sum=0;
        for (int i=0;i<input.length;i++){
            sum+=input[i];
        }

        return -1;
    }
    public static void backtrace(int[] input){

    }
}
