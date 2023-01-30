//User function Template for Java

/*class Node{

    int data;

    Node left,right;

    Node(int d)

    {

        data=d;

        left=right=null;

    }

}*/

// Function should return the root of the bst formed using postorder traversal.

class GFG

{

    public static Node constructTree(int post[],int n)

    {

        //Add your code here.MAX_VALUE

        Node NT =buildBSTfromPost(post, Integer.MAX_VALUE,new int[]{post.length-1});

        return NT;

    }

     static Node buildBSTfromPost(int[] A,int bound,int[] i){

        if(i[0]<0 || A[i[0]]<bound) return null;

        Node node = new Node(A[i[0]--]);

        node.right = buildBSTfromPost(A,node.data,i);

        node.left=buildBSTfromPost(A,bound,i);

        return node;

    }

}
