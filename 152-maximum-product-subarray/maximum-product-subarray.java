class Solution {
    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        

        int currentMax = nums[0];
        int currentMin = nums[0];
        int maximum = nums[0];

        

        for(int i =1; i<nums.length; i++){
            
            int current = nums[i];

            if(current < 0){
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(current, currentMax * current);
            currentMin = Math.min(current, currentMin * current);

            maximum = Math.max(maximum, currentMax);
        }
        return maximum;
    }
}