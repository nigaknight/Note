package leetcode5;


/**
 * @author nigaknight
 * @time 2019/9/28
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for (int len=1;len<=n;len++){
            for (int i=0;i<=n-len;i++){
                int j=i+len-1;
                if (len==1){
                    dp[i][i]=true;
                    continue;
                }
                if (len==2){
                    if (s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                    continue;
                }
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        int max=0;
        String res="";
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if (dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
