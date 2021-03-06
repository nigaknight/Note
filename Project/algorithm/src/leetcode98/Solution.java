package leetcode98;

/**
 * @author nigaknight
 * @time 2019/9/13
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 在递归左右子树的时候与左子树的数值的最大值，右子树的数值的最小值比较
 **/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean res = true;
        if (root.right != null){
            res = root.val < min(root.right);
        }
        if (root.left != null){
            res = res && (root.val > max(root.left));
        }
        return res && isValidBST(root.left) && isValidBST(root.right);
    }
    private int max(TreeNode root){
        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }
    private int min(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
