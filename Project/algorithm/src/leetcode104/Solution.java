package leetcode104;

/**
 * @author nigaknight
 * @time 2019/10/4
 **/
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
