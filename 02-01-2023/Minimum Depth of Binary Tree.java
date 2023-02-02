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
    public int minDepth(TreeNode root) {

        int res =  findminDepth(root);
        return res;

        
    }
    int findminDepth(TreeNode root){
        if(root==null)return 0;
        int ld = findminDepth(root.left);
        int rd = findminDepth(root.right);
          int tep =Math.min(ld,rd)+1;
        if(tep==1)return tep =Math.max(ld,rd)+1;
        else return tep;
    }
}
