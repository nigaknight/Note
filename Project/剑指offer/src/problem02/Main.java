package problem02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/16
 * 快手2019
 * [编程题]字符串长度最大乘积
 * https://www.nowcoder.com/test/question/480caa5ffd164ac8b71caaa6d0f4e6db?pid=13547040&tid=27602943
 * 时间限制：1秒
 *
 * 空间限制：32768K
 *
 * 已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
 * words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
 * words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
 *
 * 输入描述:
 * Input:
 *
 * ["a","ab","abc","cd","bcd","abcd"]
 *
 * 输出描述:
 * Output:
 *
 * 4
 *
 * 输入例子1:
 * ["a","ab","abc","cd","bcd","abcd"]
 *
 * 输出例子1:
 * 4
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s_temp=scanner.next();
        String s=s_temp.substring(1,s_temp.length()-1);
        String[] strings = s.split(",");
        int res=0;
        for (int i=0;i<strings.length;i++){
            ArrayList<Character> list=new ArrayList<>();
            for (int k=1;k<strings[i].length()-1;k++){
                list.add(strings[i].charAt(k));
            }
            for (int j=i+1;j<strings.length;j++){
                boolean nochongfu=true;
                for (int k=1;k<strings[j].length()-1;k++){
                    if (list.contains(strings[j].charAt(k))){
                        nochongfu=false;
                        break;
                    }
                }
                if (nochongfu){
                    res= Math.max(res,(strings[i].length()-2)*(strings[j].length()-2));
                }
            }
        }
        System.out.println(res);
    }
}
