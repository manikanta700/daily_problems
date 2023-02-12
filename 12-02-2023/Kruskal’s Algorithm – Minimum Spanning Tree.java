//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class DisjointSet{
     int[] rank ;
     int[] parent ;
     
    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        
       for(int i=0;i<=n;i++){
           rank[i]=0;
           parent[i]=i;
       }
    }
    public int findParent(int node){
        if(node==parent[node]){
            return node;
        }
        int uparent = findParent(parent[node]);
        parent[node]=uparent;
        return parent[node];
    }
    
    public void unionByRank(int u,int v){
        int parent_u = findParent(u);
        int parent_v = findParent(v);
        if(parent_u==parent_v)return;
        if(rank[parent_u]>rank[parent_v]){
            parent[parent_v]=parent_u;
        }
        else if(rank[parent_u]<rank[parent_v]){
            parent[parent_u]=parent_v;
        }
        else{
            parent[parent_v]=parent_u;
            rank[parent_u]+=1;
        }
    }
    
    
    }
    
    
class Node implements Comparable<Node>{
    int u;
    int v;
    int wt;
    public Node(int u,int v,int wt){
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
    public int compareTo(Node node){
        return this.wt-node.wt;
    }
}


class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<Node> arr = new ArrayList<>();
	    
	    for(int i=0;i<E;i++){
	       // System.out.println(edges[i][0]+" "+edges[i][1]+" "+edges[i][2]);
	        arr.add(new Node(edges[i][0],edges[i][1],edges[i][2]));
	    }
	    Collections.sort(arr);
	    DisjointSet ds = new DisjointSet(V);
	    int wtres=0;
	    for(int i=0;i<E;i++){
	    
	        if(ds.findParent(arr.get(i).u)!= ds.findParent(arr.get(i).v)){
	            wtres+=arr.get(i).wt;
	            ds.unionByRank(arr.get(i).u,arr.get(i).v);
	            

	            
	            
	        }
	    }
	    
	    return wtres;
	}
}
