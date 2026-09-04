class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){

                if(grid[i][j] == 2){
                    int[] a = {i, j};
                    q.add(a);
                }
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        while(!q.isEmpty() && freshCount > 0){

            int size = q.size();
            for(int a = 0; a<size; a++){

                int[] position = q.poll();

                int i = position[0];
                int j = position[1];

                int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };

            for (int[] d : directions) {

                int r = i + d[0];
                int c = j + d[1];

                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {

                    grid[r][c] = 2;

                    int[] array = {r, c};
                    q.add(array);
                    freshCount--;
                }  
            }
            }
            minutes++;
            
        }
        
        if(freshCount > 0){
            return -1;
        }
        return minutes;
        
        
    }
}