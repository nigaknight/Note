package leetcode107;

import java.util.*;

/**
 * @author nigaknight
 * @time 2019/10/4
 **/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int toBeVisit=1;
        int nextVisit=0;
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            toBeVisit--;
            if (node.left!=null){
                queue.offer(node.left);
                nextVisit++;
            }
            if (node.right!=null){
                queue.offer(node.right);
                nextVisit++;
            }
            if (toBeVisit==0){
                res.add(0,list);
                list=new ArrayList<>();
                toBeVisit=nextVisit;
                nextVisit=0;
            }
        }
        return res;
    }
}
