/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private String str = "";
    public String serialize(TreeNode root) {
        return PreOrder(root);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] arr = data.split("#");
        // System.out.println(Integer.parseInt(arry[0])*2);

         TreeNode TN = PreToBst(arr,Integer.MAX_VALUE,new int[]{0});
        return TN;
 
    }
    public String PreOrder(TreeNode node ){
        if(node==null)return "#";
        if(str.equals("")){
            str=str+node.val;
        }
        else{
             str=str+"#"+node.val;
        }
        
        PreOrder(node.left);
        PreOrder(node.right);

        return str;
    }
    public TreeNode PreToBst(String[] data,int bound,int[] A){
        
        
        if(A[0]>=data.length || Integer.parseInt(data[A[0]])>bound ) return null;
       
        TreeNode node = new TreeNode(Integer.parseInt(data[A[0]++]));
        node.left=PreToBst(data,node.val,A);
        node.right=PreToBst(data,bound,A);

        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
