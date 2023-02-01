import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> arrayList = new ArrayList<>();
        leftView(root,arrayList,0);
        return arrayList;

    }
    static void leftView(TreeNode node,ArrayList arr,int level){
        if(node==null) return ;
        if(arr.size()==level){
            arr.add(node.data);
        }
        leftView(node.left,arr,level+1);
        leftView(node.right,arr,level+1);
    }
}
