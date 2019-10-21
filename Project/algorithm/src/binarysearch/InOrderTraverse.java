package binarysearch;

/**
 * @author nigaknight
 * @time 2019/10/17
 **/
public class InOrderTraverse {
    public static void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
