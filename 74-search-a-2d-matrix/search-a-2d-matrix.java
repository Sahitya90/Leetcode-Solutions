class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1 ;

        while(top<=bottom){
            int newRow = top + (bottom - top)/2;

            if(target > matrix[newRow][col-1]){
                top = newRow + 1;
            }
            else if(target < matrix[newRow][0]){
                bottom = newRow -1;
            }
            else{
                break;
            }
        }
        int Row = (top + bottom) /2;
        int left = 0; 
        int right = col -1;
        while(left<=right){
           int mid = left + (right - left)/2;
            
            if(target > matrix[Row][mid]){
                left = mid + 1;
            }
            else if(target < matrix[Row][mid]){
                right = mid - 1;
            }
            else{
                return true;
            }

        }
        return false;

    }
}