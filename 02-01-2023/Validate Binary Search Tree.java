/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    
        
    }
    boolean isBST(TreeNode root,Long max_val,Long min_val){
        if(root==null)return true;
        if(root.val>=max_val || root.val<=min_val){
            return false;
        }
        return isBST(root.left,Long.valueOf(root.val),min_val) && isBST(root.right,max_val,Long.valueOf(root.val));
    }
}
