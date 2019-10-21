package binarysearch;

/**
 * @author nigaknight
 * @time 2019/10/17
 **/
public class AddNode {
    public static void main(String[] args) {
        int[] array={2,5,9,12,13,15,17,18,19};
        TreeNode root = ArrayToTree.arrayToTree(array);
        LeverOrderTraverse.levelOrder(root);
        System.out.println("添加结点后：");
        addnode(root,new TreeNode(8));
        LeverOrderTraverse.levelOrder(root);
    }
    public static void addnode(TreeNode root,TreeNode z){
        TreeNode x=root;
        TreeNode p=null;
        while (x!=null){
            p=x;
            if (z.val<x.val){
                x=x.left;
            } else {
                x=x.right;
            }
        }
        if (p==null){
            root=z;
        } else if (p.val<z.val){
            p.right=z;
        } else {
            p.left=z;
        }
    }
}
