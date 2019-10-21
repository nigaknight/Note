package problem02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/7
 **/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int t_temp=0;
        while (t_temp<t){
            int n=scanner.nextInt();
            t_temp++;
            int n_temp=0;
            int[][] node=new int[n][3];
            while (n_temp<n){
                node[n_temp][0]=scanner.nextInt();
                node[n_temp][1]=scanner.nextInt();
                node[n_temp][2]=scanner.nextInt();
                n_temp++;
            }
            boolean res=isIncTree(node);
            if (res){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
/*            System.out.println("n="+n);
            for (int i=0;i<node.length;i++){
                for (int j=0;j<node[0].length;j++){
                    System.out.print(node[i][j]+" ");
                }
                System.out.println();
            }*/
        }
    }
    public static boolean isIncTree(int[][] nums){
        TreeNode[] treeNodes=new TreeNode[nums.length];
        for (int i=0;i<nums.length;i++){
            treeNodes[i]=new TreeNode(nums[i][0]);
        }
        TreeNode root=treeNodes[0];
        int[] ishappen=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if(nums[i][1]!=-1){
                ishappen[nums[i][1]]++;
            }
            if (nums[i][2]!=-1){
                ishappen[nums[i][2]]++;
            }
        }
        for (int i=0;i<ishappen.length;i++){
            if(ishappen[i]==0){
                root=treeNodes[i];
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i][1]!=-1){
                treeNodes[i].left=treeNodes[nums[i][1]];
            }
            if (nums[i][2]!=-1){
                treeNodes[i].right=treeNodes[nums[i][2]];
            }
        }
/*        System.out.println("inOrder start");
        inOrder(root);
        System.out.println("inOrder end");*/
        return order(root);
    }
/*    public static void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }*/

    public static boolean order(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int sum=root.val;
        int toBeVisit=1;
        int nextLevel=0;
        int sum_temp=0;
        while (!queue.isEmpty()){
            TreeNode cur=queue.remove();
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
            toBeVisit--;
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

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
