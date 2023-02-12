// Online Java Compiler
// Use this editor to write, compile and run your Java code online



import java.util.*;

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



class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        DisjointSet ds = new DisjointSet(7);
	    ds.unionByRank(1,2);
	    ds.unionByRank(2,3);
	    ds.unionByRank(4,5);
	    ds.unionByRank(6,7);
	    ds.unionByRank(5,6);
	    
	    System.out.println(ds.findParent(3));
	    System.out.println(ds.findParent(7));
	    
	    ds.unionByRank(3,7);
	    
	    System.out.println(ds.findParent(3));
	    System.out.println(ds.findParent(7));
    }
}
