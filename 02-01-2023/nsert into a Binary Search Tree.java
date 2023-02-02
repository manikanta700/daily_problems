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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
    TreeNode rot = insertNode(root,val);
        return rot;
    } 
      static  TreeNode insertNode(TreeNode root,int data){
            if(root==null){
                 
                return new TreeNode(data);

            }
            else if(root.val>data){
               root.left = insertNode(root.left,data);
            }
            else if(root.val<data){
               root.right=insertNode(root.right,data);
        }
          return root;
            
        }
}
