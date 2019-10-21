package leetcode145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/10/4
 **/
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root==null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(0,node.val);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        return res;
    }
}
