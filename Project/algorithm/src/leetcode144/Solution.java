package leetcode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/10/4
 **/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (!stack.isEmpty()||curr!=null){
            if (curr!=null){
                res.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            } else {
                curr=stack.pop();
                curr=curr.right;
            }
        }
        return res;
    }
}
