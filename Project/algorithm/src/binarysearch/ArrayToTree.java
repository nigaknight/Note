package binarysearch;

/**
 * @author nigaknight
 * @time 2019/10/17
 **/
public class ArrayToTree {
    public static TreeNode arrayToTree(int[] array){
        return helper(array,0,array.length-1);
    }
    private static TreeNode helper(int[] array,int left,int right){
        if (left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(array[mid]);
        root.left=helper(array,left,mid-1);
        root.right=helper(array,mid+1,right);
        return root;
    }
/*    private static int maxInArray(int[] array,int left,int right){
        int max_index=left;
        for (int i=left+1;i<=right;i++){
            if (array[i]>array[max_index]){
                max_index=i;
            }
        }
        return max_index;
    }*/
}
