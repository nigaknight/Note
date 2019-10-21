package leetcode3;

import java.util.HashSet;

/**
 * @author nigaknight
 * @time 2019/10/8
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashSet<Character> set=new HashSet<>();
        int p=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while (set.contains(c)){
                set.remove(s.charAt(p++));
            }
            set.add(c);
            max=Math.max(max,i-p+1);
        }
        return max;
    }
}
