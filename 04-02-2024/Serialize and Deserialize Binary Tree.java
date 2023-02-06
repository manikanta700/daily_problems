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
    public String serialize(TreeNode root) {
        if(root==null)return "";
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        String str = "";
        while(!Q.isEmpty()){

            TreeNode node = Q.poll();
            if(node==null){
                str=str+",#";
            }
            else{

                str=str+","+String.valueOf(node.val);
                Q.add(node.left);
                Q.add(node.right);

            }


        }
        return str;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        String[] arr = data.split(",");
        TreeNode  root = new TreeNode(Integer.parseInt(arr[1]));
        int index = 2;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            TreeNode node = Q.poll();
            if(arr[index].equals("#")){
            node.left=null;
            }
            else{
                TreeNode nod = new TreeNode(Integer.parseInt(arr[index]));
                node.left=nod;
                Q.offer(nod);
            }
            index++;
            if(arr[index].equals("#")){
            node.right=null;
            }
            else{
                TreeNode nod = new TreeNode(Integer.parseInt(arr[index]));
                node.right=nod;
                Q.offer(nod);
            }
            index++;
            

        }

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
