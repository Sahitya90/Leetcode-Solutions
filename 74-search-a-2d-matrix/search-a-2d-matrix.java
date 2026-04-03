class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length -1;
        int col = matrix[0].length -1;

        int left = 0;
        int right = col;
        int top = 0;
        int bottom = row;
        int targetRow = 0;

        while(top<=bottom){
            int mid = top + (bottom - top) /2;

            if(target > matrix[mid][right]){
                top = mid +1;
            }
            else if(target < matrix[mid][left]){
                bottom = mid -1;
            }
            else{
                targetRow = mid;
                break;
            }
        }

        while(left<=right){
            int mid = left + (right - left) /2;

            if(target> matrix[targetRow][mid]){
                left = mid + 1;
            }
            else if(target < matrix[targetRow][mid]){
                right = mid -1;
            }
            else{
                return true;
            }
        }
       return false;

    }
}