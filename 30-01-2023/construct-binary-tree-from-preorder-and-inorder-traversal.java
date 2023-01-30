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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> HM = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            HM.put(inorder[i],i);
        }
         TreeNode TN= buildTree(preorder, inorder,0,preorder.length-1,0,inorder.length-1, HM);

        return TN; 
    }

        static TreeNode buildTree(int[] preorder, int[] inorder,int ps,int pe,int is,int ie,HashMap<Integer,Integer> HM){

            if(ps>pe || is>ie) return null;

            TreeNode node = new TreeNode(preorder[ps]);
            int rootIdx = HM.get(preorder[ps]);
            int remElems = rootIdx-is;
            node.left=buildTree(preorder,inorder, ps+1,ps+remElems, is, rootIdx-1,HM);
            node.right=buildTree(preorder,inorder, ps+remElems+1,pe, rootIdx+1,ie,HM);

            return node;


        
    }
}
