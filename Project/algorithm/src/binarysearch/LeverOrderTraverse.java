package binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author nigaknight
 * @time 2019/10/17
 **/
public class LeverOrderTraverse {
    public static void levelOrder(TreeNode root){
        if (root==null){
            System.out.println("树为空");
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int toBeVisited=1;
        int nextToVisited=0;
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            toBeVisited--;
            if (node.left!=null){
                queue.offer(node.left);
                nextToVisited++;
            }
            if (node.right!=null){
                queue.offer(node.right);
                nextToVisited++;
            }
            if (toBeVisited==0){
                System.out.println(list);
                list=new ArrayList<>();
                toBeVisited=nextToVisited;
                nextToVisited=0;
            }
        }
    }
}
