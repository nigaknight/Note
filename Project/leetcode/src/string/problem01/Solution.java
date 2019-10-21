package string.problem01;

/**
 * @author nigaknight
 * @time 2019/9/5
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 **/
public class Solution {
    public String addBinary(String a, String b) {
        int aLen=a.length()-1;
        int bLen=b.length()-1;
        int sum=0;
        StringBuilder s=new StringBuilder();
        while(aLen>=0||bLen>=0){
            if(aLen>=0){
                sum+=a.charAt(aLen--)-'0';
            }
            if(bLen>=0){
                sum+=b.charAt(bLen--)-'0';
            }
            s.append(sum%2);
            sum=sum/2;
        }
        if(sum!=0){
            s.append(1);
        }
        return s.reverse().toString();
    }
}
