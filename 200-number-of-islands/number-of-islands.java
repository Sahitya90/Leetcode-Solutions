class Solution {

    public void dfs(char[][] grid, int i, int j, boolean[][] vis){
         if(i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0' || vis[i][j] == true){
            return;
        }

        vis[i][j] = true;

            dfs(grid, i-1, j, vis);
               
            dfs(grid, i+1, j, vis);
               
            dfs(grid, i, j -1, vis);
              
            dfs(grid, i, j + 1, vis);
                
    }
    
    public int numIslands(char[][] grid) {

        int i, j;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int landCount = 0;

        for(i = 0; i<m; i++){
            for(j = 0; j<n; j++){

                if(vis[i][j]== false && grid[i][j] == '1'){
                    dfs(grid, i, j, vis);
                    landCount++;
                }
            }
        }
        return landCount;
        }
        
    
}