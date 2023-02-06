class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int nubr = image.length;
        int nubc = image[0].length;
        int[][] visted = new int[nubr][nubc];
        int count=0;
        int currentColor = image[sr][sc];
           
        dfs(image,visted,sr,sc,currentColor,color);    

        return image;
        
    }
    public void  dfs(int[][] grid ,int[][] visted,int row,int col,int curColor,int color){
        visted[row][col]=1;
        grid[row][col]=color;


        int[] rmove = {-1,0,+1,0};
        int[] cmove = {0,+1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<4;i++){
            int nrow = row+rmove[i];
            int ncol = col+cmove[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visted[nrow][ncol]==0 && grid[nrow][ncol]==curColor){
                dfs(grid,visted,nrow,ncol,curColor,color);
            }

        }

    }
}
