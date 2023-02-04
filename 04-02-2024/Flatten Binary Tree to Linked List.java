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
    private TreeNode prev;
    public void flatten(TreeNode root) {
        reArrange(root);
        
    }
    public void reArrange(TreeNode node){
        if(node==null)return;
        reArrange(node.right);
        reArrange(node.left);

        node.right=prev;
        node.left=null;
        prev=node;
        
        
    }
}
