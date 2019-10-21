package problem02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nigaknight
 * @time 2019/9/7
 **/
public class Test {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(2);
        treeNode.left.left.left=new TreeNode(2);
        treeNode.left.left.right=new TreeNode(4);
        treeNode.left.left.right.right=new TreeNode(7);
        boolean order = order(treeNode);
        System.out.println(order);
    }
    public static boolean order(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int sum=root.val;
        int toBeVisit=1;
        int nextLevel=0;
        int sum_temp=0;
        while (!queue.isEmpty()){
            TreeNode cur=queue.remove();
            System.out.println(cur.val);
            if (cur.left!=null){
                nextLevel++;
                queue.add(cur.left);
                sum_temp+=cur.left.val;
            }
            if (cur.right!=null){
                nextLevel++;
                queue.add(cur.right);
                sum_temp+=cur.right.val;
            }
            System.out.println(sum_temp);
            toBeVisit--;
            System.out.println("toBeVisit "+toBeVisit);
            if (toBeVisit==0&&!queue.isEmpty()){
                if(sum_temp<=sum){
                    return false;
                }
                sum=sum_temp;
                sum_temp=0;
                toBeVisit=nextLevel;
                nextLevel=0;
            }
        }
        return true;
    }
}

