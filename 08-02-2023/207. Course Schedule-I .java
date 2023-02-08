class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            Graph.add(new ArrayList<>());
        }
        for(int i =0;i<prerequisites.length;i++){
            Graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] preq = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
               if(checkCycleDFS(Graph,visited,i,preq)){
                   return false;
               }
            }
        }

        return true;
   
    }

    public boolean checkCycleDFS(ArrayList<ArrayList<Integer>> Graph,boolean[] visited,int src,boolean[] preq){
        if(preq[src]){
            return true;
        }
        visited[src]=true;
        preq[src]=true;

        for(int i=0;i<Graph.get(src).size();i++){
            
            if(preq[Graph.get(src).get(i)]){
                return true;
            }
            else if(!visited[Graph.get(src).get(i)]){

               if(checkCycleDFS(Graph,visited,Graph.get(src).get(i),preq)){
                   return true;

               } 
            } 
            
            
        }
        preq[src]=false;
        return false;
    }
}
