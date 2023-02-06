
class Solution {
    public boolean isBipartite(int[][] graph) {

        int[] colorArr = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> Q = new LinkedList<>();

        for(int i=0;i<colorArr.length;i++)colorArr[i]=-1;

        for(int i=0;i<colorArr.length;i++){
            if(graph[i].length==0 || visited[i]==true){
                continue;
            }
            Q.offer(i);
            colorArr[i]=0;
            visited[0]=true;

            while(!Q.isEmpty()){
                int j = Q.poll();
                for(int val : graph[j]){
                    if(!visited[val]){
                        Q.offer(val);
                        visited[val]=true;
                        if(colorArr[j]==0){
                        colorArr[val]=1;
                        }
                        else{
                        colorArr[val]=0;

                        }
                    }
                    else if(colorArr[val]==colorArr[j]){
                        return false;
                    }
                }
            }
        }
        return true;

        
    }


}
