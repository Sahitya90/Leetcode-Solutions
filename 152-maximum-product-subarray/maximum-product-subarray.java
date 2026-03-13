class Solution {
    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        

        double currentMax = nums[0];
        double currentMin = nums[0];
        double maximum = nums[0];

        

        for(int i =1; i<nums.length; i++){
            
            double current = nums[i];

            if(current < 0){
                double temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(current, currentMax * current);
            currentMin = Math.min(current, currentMin * current);

            maximum = Math.max(maximum, currentMax);
        }
        return (int) maximum;
    }
}