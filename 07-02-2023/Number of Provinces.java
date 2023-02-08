

class Solution {
    public int findCircleNum(int[][] isConnected) {
         int nubr = isConnected.length;
        int nubc = isConnected[0].length;
        boolean[] visted = new boolean[nubr];
        int count=0;

        for(int i =0;i<nubr;i++){
         
                if( visted[i] )continue;
            
                    BFS(isConnected,visted,i);
                    count++;
                
            
        }
        return count;
        
    }
    public void BFS(int[][] isConnected,boolean[] visited,int src ){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(src);
        while(!Q.isEmpty()){
            int cur = Q.poll();
            visited[cur]=true;

            for(int i = 0 ; i<isConnected.length;i++){
               
                if(!visited[i] && isConnected[cur][i]==1){
                    Q.offer(i);
                }
            }

        }
    }
}
