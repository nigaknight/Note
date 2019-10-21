package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author nigaknight
 * @time 2019/9/9
 **/
public class BackOrder {
    public void backOrder(TreeNode root){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode currentNode=root;
        TreeNode preNode=root;
        while (currentNode!=null||!stack.isEmpty()){
            if (currentNode!=null){
                stack.push(root.left);
                currentNode=currentNode.left;
            }
            if (!stack.isEmpty()){
                TreeNode node=stack.peek().right;
                if (node==null||node==preNode){
                    TreeNode treeNode=stack.pop();
                    list.add(treeNode.val);
                    preNode=treeNode;
                    currentNode=null;
                } else {
                    currentNode=node;
                }
            }
        }
    }
}
