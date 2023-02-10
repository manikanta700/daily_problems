class Solution {
    static int time = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> res = new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++){
             adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
             adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));

         
        }
        boolean[] visited = new boolean[n];
        int[] dis_time = new int[n];
        int[] low_time = new int[n];

        DFS(adj,visited,dis_time,low_time,0,-1,res);



        


        return res;

        
    }

    public void DFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int[] dis_time,int[] low_time,int src,int parent,List<List<Integer>> res){

        visited[src]=true;
        dis_time[src]=time;
        low_time[src]=time;
        time++;
        for(int v : adj.get(src)){
            if(v==parent)continue;
            if(!visited[v]){
                DFS(adj,visited,dis_time,low_time,v,src,res);
                low_time[src]=Math.min(low_time[src],low_time[v]);
                if(low_time[v]>dis_time[src]){
                    System.out.println(src+" "+v);
                    res.add(new ArrayList<>(Arrays. asList(src,v)));
                }
            }
            else{
                low_time[src]=Math.min(low_time[src],low_time[v]);


            }
        }

    }
}
