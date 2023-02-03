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
    private int count = 1;
    private int res ;
    public int kthSmallest(TreeNode root, int k) {

        inOrder(root,k);
        return res;
    }
    public void  inOrder(TreeNode node,int k){
        if( node==null || count>k ) return ;
        inOrder(node.left,k);
        if(count==k){
            res = node.val;
        }
        count++;
        inOrder(node.right,k);
        
    }
}
