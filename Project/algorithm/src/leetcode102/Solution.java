package leetcode102;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/9
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return res;
        }
        helper(root,0);
        return res;
    }
    private void helper(TreeNode root, int level){
        if (res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left!=null){
            helper(root.left,level+1);
        }
        if (root.right!=null){
            helper(root.right,level+1);
        }
    }
}
