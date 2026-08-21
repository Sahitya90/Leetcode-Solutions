class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int r = 0;

        

        for(int right = 0; right < n; right ++){

            int val = nums[right];

             
            while(!dq.isEmpty() && val > nums[dq.peekLast()] ){
                dq.pollLast();
            }

            dq.addLast(right);

            if(dq.peek() < right - k + 1){
                dq.pollFirst();
            }
            if(right >= k - 1){
                result[r] = nums[dq.peekFirst()];
                r++;
            }
            


        }
        return result;
    }
}