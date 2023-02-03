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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null)return null;
        if(root.val==key)return RemoveNode(root);
        TreeNode temp = root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left=RemoveNode(root.left);

                }
                else{
                    root=root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right=RemoveNode(root.right);

                }
                else{
                    root=root.right;
                }

            }
        }
        return temp;

        
    }

    public TreeNode RemoveNode(TreeNode root){
        
        if(root.right==null)return root.left;
        if(root.left==null)return root.right;
        TreeNode tep = root.left;
        getLastLeftNode(root.right).left=tep;
        return root.right;
    }
    public TreeNode  getLastLeftNode(TreeNode node){
        if(node.left==null)return node;
        return getLastLeftNode(node.left);
    }
}
