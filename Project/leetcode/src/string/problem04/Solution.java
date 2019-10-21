package string.problem04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/5
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 **/
public class Solution {
    public List<List<String>> partition(String s) {
        // 分治法，类似于暴力穷举，在穷举的同时判断是否是回文串；
        List<List<String>> lists = partitionHelper(s, 0);
        return lists;
    }
    public List<List<String>> partitionHelper(String s,int start){
        // 递归出口：字符串的长度为0的时候返回空的结果
        if(start==s.length()){
            List<String> list=new ArrayList<>();
            List<List<String>> res=new ArrayList<>();
            res.add(list);
            return res;
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=start;i<s.length();i++){
            if(isHuiwen(s.substring(start,i+1))){
                String left=s.substring(start,i+1);
                List<List<String>> lists = partitionHelper(s, i + 1);
                for(List<String> list:lists){
                    list.add(0,left);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public boolean isHuiwen(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
