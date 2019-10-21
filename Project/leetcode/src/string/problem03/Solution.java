package string.problem03;

/**
 * @author nigaknight
 * @time 2019/9/5
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 **/
public class Solution {
    public static boolean isPalindrome(String s) {
        // 将非字母去掉：重新建一个stringbuilder保存无空格字符串
        // reverse，然后比较两字符串是否相同
        StringBuilder sb=new StringBuilder();
        if(s.equals("")){
            return true;
        }
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)<='z'&&s.charAt(i)>='a')||(s.charAt(i)<='Z'&&s.charAt(i)>='A')||
                    (s.charAt(i)<='9'&&s.charAt(i)>='0')){
                sb.append(s.charAt(i));
            }
        }
        String s_origin=sb.toString().toLowerCase();
        System.out.println(s_origin);
        StringBuilder sb_reverse = sb.reverse();
        String s_reverse=sb_reverse.toString().toLowerCase();
        System.out.println(s_reverse);
        return s_reverse.equals(s_origin);
    }

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
}
