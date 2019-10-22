package leetcode557;

/**
 * @author nigaknight
 * @time 2019/10/22
 * StringBuilder自带字符串反转的函数reverse
 * 去除收尾空格可以用trim函数
 **/
public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = reverse(ss[i]);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            res.append(ss[i]);
            if (i != ss.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    private static String reverse(String s) {
        StringBuilder rev = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
}
