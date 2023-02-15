class Solution {
    public boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if(DFS(0,0,grid,visited))return true;

        return false;
        
    }
    int dis[][][] = {

        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{1,0},{0,1}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}},
   
    };

    public boolean DFS(int r,int c,int[][] grid,boolean[][] visited){
        if(r==grid.length-1 && c==grid[0].length-1)return true;
        visited[r][c]=true;
        for(int[] entx : dis[grid[r][c]-1]){
            int nr=r+entx[0];
            int nc=c+entx[1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !visited[nr][nc]){
                    for(int[] enty : dis[grid[nr][nc]-1]){
                        if(nr+enty[0]==r && nc+enty[1]==c){
                            if(DFS(nr,nc,grid,visited))return true;
                        }

                    }


            }
            
        }return false;
    }
}
