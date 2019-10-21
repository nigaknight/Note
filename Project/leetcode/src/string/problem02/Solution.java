package string.problem02;

import java.util.Arrays;

/**
 * @author nigaknight
 * @time 2019/9/5
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 排序，然后比较第一个和最后一个字符串即可
        // 排序
        Arrays.sort(strs);
        // 结果存入stringbuilder
        StringBuilder s=new StringBuilder();
        if(strs.length==0){
            return s.toString();
        }
        // 第一个字符最短
        for(int i=0;i<strs[0].length();i++){
            if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)){
                s.append(strs[0].charAt(i));
            }
            else{
                return s.toString();
            }
        }
        return s.toString();
    }
}
