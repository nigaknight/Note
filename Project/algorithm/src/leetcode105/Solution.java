package leetcode105;

/**
 * @author nigaknight
 * @time 2019/10/12
 **/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    private TreeNode helper(int[] preorder,int[] inorder,int p_left,int p_right,int i_left,int i_right){
        if (p_left==p_right){
            return null;
        }
        int root_val=preorder[p_left];
        TreeNode root=new TreeNode(root_val);
        int root_index=0;
        for (int i=i_left;i<i_right;i++){
            if (inorder[i]==root_val){
                root_index=i;
            }
        }
        int length=root_index-i_left;
        root.left=helper(preorder,inorder,p_left+1,p_left+length+1,i_left,root_index);
        root.right=helper(preorder,inorder,p_left+length+1,p_right,root_index+1,i_right);
        return root;
    }
}
