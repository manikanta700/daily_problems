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
    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode TN = buildBSTfromPeorder(preorder,Integer.MAX_VALUE,new int[]{0});
        return TN;
        
    }
    public TreeNode buildBSTfromPeorder(int[] A,int bound,int[] i){
        if(i[0]>A.length-1 || A[i[0]]>bound) return null;
        TreeNode node =new TreeNode(A[i[0]++]);
        node.left=buildBSTfromPeorder(A,node.val,i);
        node.right=buildBSTfromPeorder(A,bound,i);

        return node;



    }
}
