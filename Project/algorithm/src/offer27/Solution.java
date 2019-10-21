package offer27;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author nigaknight
 * @time 2019/9/9
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 **/
public class Solution {
    ArrayList<String> list=new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return list;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder s=new StringBuilder();
        boolean[] isUsed=new boolean[chars.length];
        dfs(chars,s,isUsed);
        return list;
    }
    public void dfs(char[] chars,StringBuilder s,boolean[] isUsed){
        if (s.length()==chars.length){
            list.add(s.toString());
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (isUsed[i]){
                continue;
            }
            if (i!=0&&chars[i]==chars[i-1]&&!isUsed[i-1]){
                continue;
            }
            isUsed[i]=true;
            s.append(chars[i]);
            dfs(chars,s,isUsed);
            s.deleteCharAt(s.length()-1);
            isUsed[i]=false;
        }
    }
}
