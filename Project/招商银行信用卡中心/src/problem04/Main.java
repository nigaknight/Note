package problem04;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/15
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nodes = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            nodes[i][0] = scanner.nextInt();
            nodes[i][1] = scanner.nextInt();
            nodes[i][2] = scanner.nextInt();
        }
        TreeNode root=new TreeNode(0);
        TreeNode[] tree=new TreeNode[n];
        tree[0]=root;
        for (int i=1;i<n;i++){
            tree[i]=new TreeNode(nodes[i-1][2]);
        }
        for (int i=0;i<n-1;i++){
            if (tree[nodes[i][0]-1].left==null){
                tree[nodes[i][0]-1].left=tree[nodes[i][1]-1];
            } else {
                tree[nodes[i][0]-1].right=tree[nodes[i][1]-1];
            }
        }
        int[] res=new int[n];
        for (int i=0;i<=n-1;i++){
            res[i]=tree[i].getMax();
            res[i]=res[i]<0?0:res[i];
            System.out.print(res[i]+" ");
        }

    }
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
        int getMax(){
            if (this.right==null&&this.left==null){
                return 0;
            } else if(this.right!=null&&this.left==null){
                return right.getMax()+right.val;
            } else if (this.right==null&&this.left!=null){
                return left.getMax()+left.val;
            } else {
                return Math.max(right.getMax()+right.val,left.getMax()+left.val);
            }
        }
    }
}
