class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){

            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] preq = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean cycle = false;
        Stack<Integer> stk = new Stack<>();

        for(int i=0;i<numCourses;i++){
           if(!visited[i]){
           if(DFS(i ,adj,preq,visited,stk)){
               cycle=true;
           }
           }
        }

        System.out.println(cycle);
        if(cycle)return new int[]{};
        else{
            int[] arr = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                arr[i]=stk.pop();
            }
            return arr;
        }



        
        
    }
    public boolean DFS(int src , ArrayList<ArrayList<Integer>> adj,boolean[] preq,boolean[] visited,Stack<Integer> stk){
        if(preq[src])return true;
        preq[src]=true;
        visited[src]=true;
        for(int i:adj.get(src)){
            if(preq[i])return true;

            else if(!visited[i]){
                if(DFS(i ,adj,preq,visited,stk)){
                    return true;
                }

            }
        }
        preq[src]=false;
        stk.push(src);
        return false;
    }
}
