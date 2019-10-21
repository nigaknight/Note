package huawei.problem01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/11
 **/
public class Main {
    static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] tem1 = s.split("R");
        String[] tem2 = tem1[0].split("B");
        String AString=tem2[0].substring(3,tem2[0].length()-2);
        String BString=tem2[1].substring(2,tem2[1].length()-2);
        String R=tem1[1].substring(1);
        String[] A = AString.split(",");
        String[] B = BString.split(",");
        solution(A,B);
    }
    ArrayList<String> res=new ArrayList<>();
    public static void solution(String[] A, String[] B){
        int start=0;
        for (int i=0;i<A.length;i++){
            int a=Integer.valueOf(A[i]);
            for (int j=start;j<B.length;j++){
                int b=Integer.valueOf(B[j]);
                if (a<=b){
                    map.put(a,b);
                    start++;
                    break;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<A.length;i++){
            sb.append('(');
            sb.append(Integer.valueOf(A[i]));
            sb.append(',');
            sb.append(Integer.valueOf(B[i]));
            sb.append(')');
        }
    }
}
