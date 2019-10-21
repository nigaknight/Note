package problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/22
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {

        // TODO Write your code here
        int n=input[0];
        int m=input[1];
        boolean[] out=new boolean[n+1];
        List<Integer> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int count=1;
        while (list.size() != n) {
            for (int i = 1; i <= n; i++) {
                if (!out[i]) {
                    if (count % m == 0) {
                        list.add(i);
                        out[i] = true;
                    }
                    count++;
                }
            }
        }
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        return sb.toString();
    }
}
