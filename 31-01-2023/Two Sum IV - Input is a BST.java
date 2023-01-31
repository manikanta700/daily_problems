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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        BSTIterator bstiF = new BSTIterator(root,true);
        BSTIterator bstiB = new BSTIterator(root,false);

       int i = bstiF.next();
       int j = bstiB.next();

        while(i<j){
            if(i+j==k){
                return true;
            }
            else if(i+j>k){
                j=bstiB.next();
            }
            else{
               i=bstiF.next();
            }
        }
        return false;
        
    }
    class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean forward;

    public BSTIterator(TreeNode root,boolean forward) {
        this.forward=forward;
        pushAll(root);
        
        
    }

    public void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            if(forward){
            node=node.left;
            }
            else{
            node=node.right;
            }
        }
    }
    
    public int next() {
        
          TreeNode  node=stack.pop();
          if(forward){
          pushAll(node.right);
          }
          else{
          pushAll(node.left);

          }
          return node.val;

        
    }
        
    
    
    public boolean hasNext() {
        
        return !stack.empty();        
    }
}
}
