class Pair implements Comparable<Pair>{
    int dis ;
    int row;
    int col;
    public Pair(int dis,int row,int col){
        this.dis=dis;
        this.row=row;
        this.col=col;
    }
    public int compareTo(Pair p){
        if(this.dis==p.dis)  
          return 0;  
        else if(this.dis>p.dis)  
          return 1;  
        else  
          return -1;  
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid.length-1][grid.length-1]!=0) return -1;
        if(grid.length==1 && grid[0][0]==0)return 1;

        PriorityQueue<Pair> PQ = new PriorityQueue<>();
        PQ.add(new Pair(1,0,0));
        while(!PQ.isEmpty()){
            Pair p = PQ.poll();
            int r = p.row;
            int c = p.col;
            int d = p.dis;

            int[] rmove = {-1,-1,-1,0,1,1,1,0};
            int[] cmove = {-1,0, 1, 1,1,0,-1,-1};

            for(int i=0;i<rmove.length;i++){
                int nrow = r+rmove[i];
                int ncol = c+cmove[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid.length && grid[nrow][ncol]==0){
                System.out.println(nrow+"jhh"+ncol);

                     grid[nrow][ncol]=1;
                    if(nrow==grid.length-1 && ncol==grid.length-1){
                    return d+1;
                    }
                    PQ.add(new Pair(d+1,nrow,ncol));
                    
                }
            }

        }
        return -1;

        
    }


}
