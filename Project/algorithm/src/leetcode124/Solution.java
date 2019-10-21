package leetcode124;

/**
 * @author nigaknight
 * @time 2019/10/3
 **/
public class Solution {
    private int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode node){
        if (node==null){
            return 0;
        }
        int maxleft=Math.max(helper(node.left),0);
        int maxright=Math.max(helper(node.right),0);
        int temp=maxleft+maxright+node.val;
        res=Math.max(res,temp);
        return node.val+Math.max(maxleft,maxright);
    }
}
