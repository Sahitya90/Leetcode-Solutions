import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1; // no. of rows is the bottom boundary
        int left = 0;
        int right = matrix[0].length-1; // no. of columns is the right boundary
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        while(left<=right && top<=bottom){
            //get every element in the top row
            for(int i =left; i<=right; i++){
                result.add(matrix[top][i]);
                
            }
            top++;
            //get every element in last column
            for(int i = top;i<=bottom; i++ ){
                result.add(matrix[i][right]);
                
            }
            right--;
            //special case condition
            if(!(left<=right && top<=bottom)){
                break;
            }
            //get every element in last row
            for(int i = right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom --;
            //get every element in first column
            for(int i = bottom; i>=top; i--){
                result.add(matrix[i][left]);
                
            }
            left ++ ;
            //get every element in the inner matrix
            
        }
        //return the result list
        return result;
        
    }
}