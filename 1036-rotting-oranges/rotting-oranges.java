class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        //checking if places with 2, then adding them to the queue
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] ==2){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        //bfs logic
        while(!q.isEmpty()){

            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int t = curr[2];

            ans = Math.max(ans, t);

            if(i-1 >=0 && vis[i-1][j]==false && grid[i-1][j] == 1){ //top

                q.add(new int[]{i-1,j,t+1});
                vis[i-1][j] = true;
            }
            if(i+1 < n && vis[i+1][j]==false && grid[i+1][j] == 1){ //bottom

                q.add(new int[]{i+1,j,t+1});
              
                vis[i+1][j] = true;
            }
             if(j-1 >=0 && vis[i][j-1]==false && grid[i][j-1] == 1){ //left

                q.add(new int[]{i,j-1,t+1});
              
                vis[i][j-1] = true;
            }
             if(j+1 < m && vis[i][j+1]==false && grid[i][j+1] == 1){  //right

                q.add(new int[]{i,j+1,t+1});
              
                vis[i][j+1] = true;
            }


        }
        //check for fresh orange
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;

    }
}