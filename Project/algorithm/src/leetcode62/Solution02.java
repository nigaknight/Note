package leetcode62;

import java.util.Arrays;

/**
 * @author nigaknight
 * @time 2019/9/14
 **/
public class Solution02 {
    public int uniquePaths(int m, int n) {
        int[] cur=new int[n];
        Arrays.fill(cur,1);
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                cur[j]+=cur[j-1];
            }
        }
        return cur[n-1];
    }
}
