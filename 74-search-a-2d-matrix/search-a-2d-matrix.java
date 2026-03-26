class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1 ;
        int targetRow=0;

        while(top<=bottom){
            int mid = top + (bottom - top)/2;

            if(target > matrix[mid][col-1]){
                top = mid + 1;
            }
            else if(target < matrix[mid][0]){
                bottom = mid -1;
            }
            else{
                targetRow = mid;
                break;
            }
        }
        
        int left = 0; 
        int right = col -1;
        while(left<=right){
           int mid = left + (right - left)/2;
            
            if(target > matrix[targetRow][mid]){
                left = mid + 1;
            }
            else if(target < matrix[targetRow][mid]){
                right = mid - 1;
            }
            else{
                return true;
            }

        }
        return false;

    }
}