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
    public int diameterOfBinaryTree(TreeNode root) {

        int[] diaArr = new int[]{0};

        getDia(root,diaArr);
        return diaArr[0];
        
    }
    public int getDia(TreeNode root,int[] maxi){
        if(root==null)return 0;

        int lh = getDia(root.left,maxi);
        int rh = getDia(root.right,maxi);
        maxi[0]=Math.max(maxi[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}
