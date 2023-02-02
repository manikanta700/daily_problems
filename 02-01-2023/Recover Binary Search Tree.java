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
    private TreeNode first , middle ,  last , prev;

    public void recoverTree(TreeNode root) {
        inOrder(root);

        if(last==null){
            int tep = middle.val;
            middle.val=first.val;
            first.val=tep;
        }
        else{
            int tep = last.val;
            last.val=first.val;
            first.val=tep;
        }
        
    }
    void inOrder(TreeNode root){
        if(root==null)return ;
        inOrder(root.left);
        if(prev!=null && prev.val>root.val ){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
            
        }
         

        prev=root;
        inOrder(root.right);
    }
}
