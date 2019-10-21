package leetcode100;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        if (p==null){
            return false;
        }
        if (q==null){
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
