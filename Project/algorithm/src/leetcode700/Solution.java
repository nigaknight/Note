package leetcode700;

/**
 * @author nigaknight
 * @time 2019/10/18
 **/
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val>val){
            return searchBST(root.left,val);
        }
        if (root.val<val){
            return searchBST(root.right,val);
        }
        return root;
    }
}
