package problem05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nigaknight
 * @time 2019/9/5
 **/
public class Solution {
    List<Integer> list=new ArrayList<>();
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        inOrder(root);
        list.add(val);
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return constructMaximumBinaryTree(res);
    }
    public void inOrder(TreeNode root){
        // 中序遍历
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solution(nums,0,nums.length-1);
    }

    public TreeNode solution(int[] nums,int i,int j){
        if(i<=j){
            int max_index=max(nums,i,j);
            TreeNode treeNode=new TreeNode(nums[max_index]);
            treeNode.left=solution(nums,i,max_index-1);
            treeNode.right=solution(nums,max_index+1,j);
            return treeNode;
        }
        return null;
    }

    public int max(int[] subnums,int i,int j){
        // 返回最大值所在下标
        int max=Integer.MIN_VALUE;
        int max_index=i;
        for(int x=i;x<=j;x++){
            if(subnums[x]>max){
                max=subnums[x];
                max_index=x;
            }
        }
        return max_index;
    }
}
