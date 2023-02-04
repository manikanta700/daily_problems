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
 class Pair{
     TreeNode node;
     int col;
     int row;
     public Pair(TreeNode node,int col,int row){
         this.node=node;
         this.col=col;
         this.row=row;

     }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(root,0,0));

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> myMap = new TreeMap<>();
        while(!Q.isEmpty()){
            Pair p = Q.remove();
            int col = p.col;
            int row = p.row;


            if(!myMap.containsKey(col)){
                myMap.put(col,new TreeMap<>());
            }
            if(!myMap.get(col).containsKey(row)){
                myMap.get(col).put(row,new PriorityQueue<>());
            }
            myMap.get(col).get(row).offer(p.node.val);

            if(p.node.left!=null){
                Q.add(new Pair(p.node.left,col-1,row+1));
            }
            if(p.node.right!=null){
                Q.add(new Pair(p.node.right,col+1,row+1));
            }

        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> item : myMap.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : item.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;

    }
}
