

/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       Node dem = root;
       
       while(root!=null){
           if(key>=root.data){
               root=root.right;
           }
           else{
           
           s.succ=root;
           root=root.left;
           }
       }
       while(dem!=null){
           if(key<=dem.data){
               dem=dem.left;
           }
           else{
               p.pre=dem;
               dem=dem.right;
           }
       }
       
    }
}
