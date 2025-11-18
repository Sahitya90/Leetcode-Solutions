class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        int leftProducts = 1;

        for(int i = 0; i<n; i++){
            answer[i] = leftProducts;

            leftProducts *= nums[i];

        }

        int rightProducts = 1;

        for(int j = n -1; j>=0; j--){
            answer[j] *= rightProducts;

            rightProducts *= nums[j];
        }
        return answer;
    }
}