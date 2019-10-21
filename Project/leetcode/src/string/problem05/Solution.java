package string.problem05;

import java.util.HashSet;

/**
 * @author nigaknight
 * @time 2019/9/5
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 将所有的子串遍历出来，并进行重复字符的判断，获得最长的长度
        // 1 遍历子串：两个for循环可以遍历所有子串
        // 2 重复字符判断：遍历字符串所有字符，使用map判断是否有重复(可以直接用set判断)
        // 3 获得最长的长度：一直更新没有重复的子串的最大长度

        // 优化：遍历时遇到重复字符时，将包括前一个重复字符的前面所有字符去除；

        // 滑动窗口法：使用一个set作为滑动窗口，当当前set没有重复字符时，向右扩展，否则，减去左边的字符
        // 并将set中的重复字符去掉

        HashSet<Character> set=new HashSet<>();
        // 1 循环滑动：限制-字符串长度；
        int i=0,j=0;
        int res=Integer.MIN_VALUE;
        while (i<s.length()&&j<s.length()){
            char c=s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                res=Math.max(res,j-i+1);
                j++;
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
        // 2 逻辑判断：当当前set没有重复字符时，向右扩展，否则，减去左边的字符
    }
}
