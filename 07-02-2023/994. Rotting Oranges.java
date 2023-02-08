class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int nubr = grid.length;
        int nubc = grid[0].length;
        int[][] visted = new int[nubr][nubc];
        int Freshcount=0;
         
        Queue<Pair> Q = new LinkedList<>();
        
        for(int i =0;i<nubr;i++){
            for(int j=0;j<nubc;j++){
                if(grid[i][j]==2){
                 Q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    Freshcount++;
                }

            }
        }
        if(Freshcount==0)return 0;
        int count=0;
    while(!Q.isEmpty()){
                count++;
                int[] rmove = {-1,0,+1,0};
                int[] cmove = {0,+1,0,-1};
                int n = grid.length;
                int m = grid[0].length;
                int size = Q.size();
        for(int j = 0;j<size;j++){
                Pair p = Q.remove();
                int r = p.row;
                int c = p.col;
            for(int i = 0;i<4;i++){
                    int nrow = r+rmove[i];
                    int ncol = c+cmove[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m  && grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        Q.offer(new Pair(nrow,ncol));    
                        Freshcount--;            
                    }
                }
            
        }
                
        }
        return Freshcount==0?(count-1):-1;
        

        
    }
    public void  bfs(int[][] grid ,int[][] visited,int row,int col){


        
 

    }
}
