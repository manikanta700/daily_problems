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
    private int res = Integer.MAX_VALUE ;
    private Queue<Integer> Q = new LinkedList<>();


    public int getMinimumDifference(TreeNode root) {

        inOrder(root);
        if(Q.size()==2){
            int a = Q.remove();
            int b = Q.peek();
            if(Math.abs(a-b)<res) res=Math.abs(a-b);
        }
        return res;


        
    }
    public void  inOrder(TreeNode node){
        if( node==null) return ;
        inOrder(node.left);
        Q.add(node.val);
        if(Q.size()==2){
            int a = Q.remove();
            int b = Q.peek();
            if(Math.abs(a-b)<res) res=Math.abs(a-b);
        }

        inOrder(node.right);
        
    }
}
