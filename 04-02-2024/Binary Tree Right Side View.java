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
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> arry = new ArrayList<>();
        rightView(root,arry,0);
        return arry;
        
    }
    public void rightView(TreeNode node,ArrayList arr,int level){
        if(node==null)return;
        if(arr.size()==level){
            arr.add(node.val);
        }
        rightView(node.right,arr,level+1);
        rightView(node.left,arr,level+1);

    }

}
