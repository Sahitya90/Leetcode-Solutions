class Solution {

    public void dfs(int i , int j, int[][] image, int n, int m, int color, int startingValue){

        //base condiiton
        if(i < 0 || j < 0 || i >=n || j >=m || image[i][j] != startingValue){
            return;
        }
        image[i][j] = color;
        dfs(i-1, j, image, n, m, color, startingValue);
        dfs(i+1, j, image, n, m, color, startingValue);
        dfs(i, j-1, image, n, m, color, startingValue);
        dfs(i, j+1, image, n, m, color, startingValue);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        
        int n = image.length;
        int m = image[0].length;
        int i = sr;
        int j = sc;

        
        
        int startingValue = image[sr][sc];
        if(startingValue == color){
            return image;
        }



         dfs(i, j, image, n, m, color, startingValue);
           
        return image;
    }
}