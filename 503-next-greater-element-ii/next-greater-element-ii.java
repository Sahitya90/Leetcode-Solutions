class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        for(int i =0; i< 2 * n; i++){

            int curr = i % n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[curr]){

                    result[stack.peek()] = nums[curr];
                    stack.pop();
                
            }
            if(i<n){
                stack.push(curr);
            }
        }
        return result;
    }
}