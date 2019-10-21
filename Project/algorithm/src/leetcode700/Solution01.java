package leetcode700;

/**
 * @author nigaknight
 * @time 2019/10/18
 **/
public class Solution01 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root!=null){
            if (root.val>val){
                root=root.left;
            } else if (root.val<val){
                root=root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
