class Pair{
    int r;
    int c;
    public Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int shortestBridge(int[][] grid) {

        Deque<Pair> DQ = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    DQ.addFirst(new Pair(i,j));
                    break;

                }
            }
            if(DQ.size()>0){
                break;
            }
        }
        int[][] move={{-1,0},{0,-1},{1,0},{0,1}};
        int cnt=0;
        boolean in_water=false;
        while(!DQ.isEmpty()){
           int size=DQ.size();
           while(size>0){
            size--;
            Pair p = DQ.removeFirst();
            visited[p.r][p.c]=true;
            if(grid[p.r][p.c]==0)in_water=true;
           
            for(int i=0;i<move.length;i++){
                int nr=p.r+move[i][0];
                int nc=p.c+move[i][1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid.length && !visited[nr][nc]){

                    if(grid[nr][nc]==1 && in_water){
                        return cnt;

                    }
                    else if(grid[nr][nc]==0 ){
                        DQ.addLast(new Pair(nr,nc));
                        visited[nr][nc]=true;

                    }
                    else{
                        DQ.addFirst(new Pair(nr,nc));
                        visited[nr][nc]=true;
                        size++;
                        

                    }

                }
            }
           }
           
           cnt++;
         
            
        }

        return cnt;
        
    }
}
