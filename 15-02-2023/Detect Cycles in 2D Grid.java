class Solution {
    public boolean containsCycle(char[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0){
                    if(DFS(i,j,grid,visited,1))return true;
                    
                }

            }
        }

        return false;

    }
    public boolean DFS(int r, int c,char[][] grid,int[][] visited,int dis){
        int[] rmove={-1,0,1,0};
        int[] cmove={0,-1,0,1};
        visited[r][c]=dis;
        for(int k=0;k<4;k++){
            int nr=r+rmove[k];
            int nc=c+cmove[k];
            if(nc>=0 && nc<grid[0].length && nr>=0 && nr<grid.length && grid[r][c]==grid[nr][nc]){
                if(visited[nr][nc]==0){
                    System.out.println(nr+" "+nc);
                    if(DFS(nr,nc,grid,visited,dis+1))return true;
                }
                else if(Math.abs(visited[nr][nc]-visited[r][c])>=3){
                    return true;
                }
            }
                    }
                    return false;
    }
}
