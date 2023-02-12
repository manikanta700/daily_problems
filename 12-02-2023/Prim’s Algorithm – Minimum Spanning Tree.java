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


    
    
class Node implements Comparable<Node>{
    int u;
    int wt;
    public Node(int u,int wt){
        this.u=u;
        this.wt=wt;
    }
    public int compareTo(Node node){
        return this.wt-node.wt;
    }
}



class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    PriorityQueue<Node> PQ = new PriorityQueue<>();
	    ArrayList<ArrayList<Node>> adj = new ArrayList<>();
	    
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    
	    for(int i=0;i<E;i++){
	       // System.out.println(edges[i][0]+" "+edges[i][1]+" "+edges[i][2]);
	        //arr.add(new Node(edges[i][0],edges[i][1],edges[i][2]));
	        adj.get(edges[i][0]).add(new Node(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new Node(edges[i][0],edges[i][2]));

	    }
	    int wtres=0;
	    boolean[] visited = new boolean[V];
	    PQ.add(new Node(0,0));
	    while(!PQ.isEmpty()){
	        Node node = PQ.poll();
	        if(!visited[node.u]){
	             visited[node.u]=true;
	             wtres+=node.wt;
	             for(int i=0;i<adj.get(node.u).size();i++){
    	        if(!visited[adj.get(node.u).get(i).u]){
    	            PQ.add(new Node(adj.get(node.u).get(i).u,adj.get(node.u).get(i).wt));
    	            
    	        }
	       }
	            
	        }
	        
	       
	        
	    }
	    
	    
	    return wtres;
	}
}
