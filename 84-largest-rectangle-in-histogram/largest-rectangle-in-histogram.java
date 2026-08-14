class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        //right smaller nearest
        
        int[] right = new int[n];
        for (int i = n-1; i>= 0; i--){

            while(!s.empty() &&  heights[s.peek()] >= heights[i]){

                s.pop();

            }
            right[i] = s.empty() ? n : s.peek();
            s.push(i);


        }

        while(!s.empty()){
            s.pop();
        }

        //left smaller nearest

        int[] left = new int[n];
        for(int i = 0; i<n; i++){

            while(!s.empty() && heights[s.peek()] >= heights[i]){

                s.pop();
            }
            left[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }

        for(int i =0 ; i< n; i++){

            int width = right[i] - left[i] - 1;
            int currArea = width * heights[i];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;

    }
}