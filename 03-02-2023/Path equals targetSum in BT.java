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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPathSum(root,targetSum);

        
    }
    public boolean checkPathSum(TreeNode node,int tarsum){
        if(node==null)return false;
        int subSum = tarsum-node.val;
        if(subSum==0 && node.left==null && node.right==null)return true;
        boolean ans = false;
       
        if(node.left!=null){
            ans = ans || checkPathSum(node.left,subSum);
        }
        if(node.right!=null){
            ans = ans || checkPathSum(node.right,subSum);
        }
        return ans;
    }
}
