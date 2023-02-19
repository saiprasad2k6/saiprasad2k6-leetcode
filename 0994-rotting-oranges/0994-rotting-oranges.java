class Pair{
    int i,j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public void bfs(int [][] grid,int i,int j){
            Queue<Pair> q=new LinkedList<>();
            q.add(new Pair(i,j));
            while(!q.isEmpty()){
                Pair p=q.poll();
                int d=grid[p.i][p.j];
                if(p.i>=1 && (grid[p.i-1][p.j]==1 || d<grid[p.i-1][p.j])){
                    grid[p.i-1][p.j]=d+1;
                    q.add(new Pair(p.i-1,p.j));
                }
                if(p.j>=1 && (grid[p.i][p.j-1]==1 || d<grid[p.i][p.j-1])){
                    grid[p.i][p.j-1]=d+1;
                    q.add(new Pair(p.i,p.j-1));
                }
                if(p.i<grid.length-1 && (grid[p.i+1][p.j]==1 || d<grid[p.i+1][p.j])){
                    grid[p.i+1][p.j]=d+1;
                    q.add(new Pair(p.i+1,p.j));
                }
                if(p.j<grid[0].length-1 && (grid[p.i][p.j+1]==1 || d<grid[p.i][p.j+1])){
                    grid[p.i][p.j+1]=d+1;
                    q.add(new Pair(p.i,p.j+1));
                }
        }
    }
    public void utilfunc(int [][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    bfs(grid,i,j);
                }
            }
        }
    }
    public int orangesRotting(int[][] grid) {
        utilfunc(grid);
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                return -1;
                max=Math.max(max,grid[i][j]-2);
            }
        }
        return max;
    }
}