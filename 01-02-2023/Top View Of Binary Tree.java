import java.util.* ;
import java.io.*; 
/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/
 class Pair {
     int hd;
     BinaryTreeNode node;
     Pair(BinaryTreeNode node,int hd){
         this.hd=hd;
         this.node=node;

    }
}

public class Solution {

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
         // Write your code here.  
        Queue<Pair> Q = new LinkedList<Pair>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		if(root==null)return arr;

        Q.add(new Pair(root,0));

        while(!Q.isEmpty()){
            Pair p = Q.remove();
			 if(!treeMap.containsKey(p.hd)){
				treeMap.put(p.hd,p.node.val);
			 }
            
            if(p.node.left!=null){
                Q.add(new Pair(p.node.left,p.hd-1));
            }
            if(p.node.right!=null){
                Q.add(new Pair(p.node.right,p.hd+1));
            }

        }
        for(Map.Entry<Integer,Integer> enty : treeMap.entrySet()){
            arr.add(enty.getValue());

        }
        return arr;
    }
}
