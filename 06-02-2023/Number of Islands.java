class Solution {
    public int numIslands(char[][] grid) {
        int nubr = grid.length;
        int nubc = grid[0].length;
        int[][] visted = new int[nubr][nubc];
        int count=0;

        for(int i =0;i<nubr;i++){
            for(int j=0;j<nubc;j++){
                if(visted[i][j]==0 && grid[i][j]=='1'){
                    dfs(grid,visted,i,j);
                    count++;

                }
            }
        }
        return count;

        
    }
    public void  dfs(char[][] grid ,int[][] visted,int row,int col){
        visted[row][col]=1;

        int[] rmove = {-1,0,+1,0};
        int[] cmove = {0,+1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<4;i++){
            int nrow = row+rmove[i];
            int ncol = col+cmove[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visted[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(grid,visted,nrow,ncol);
            }

        }

    }
}
