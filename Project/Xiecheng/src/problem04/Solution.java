package problem04;


/**
 * @author nigaknight
 * @time 2019/9/4
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
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
