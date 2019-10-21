package leetcode226;

/**
 * @author nigaknight
 * @time 2019/10/4
 **/
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode right=invertTree(root.right);
        TreeNode left=invertTree(root.left);
        root.left=right;
        root.right=left;
        return root;
    }
}
