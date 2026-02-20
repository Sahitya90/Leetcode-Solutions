class Solution {
    public int maxProduct(int[] nums) {

         if (nums == null || nums.length == 0) return 0;
        
        int currentMin = nums[0];
        int currentMax = nums[0];
        int Maximum = nums[0];

        for(int i =1; i<nums.length; i++){

            int current = nums[i];

            if(current <0){
                int temp = currentMin;
                currentMin = currentMax;
                currentMax = temp;
            }

            currentMax = Math.max(current, currentMax * current);
            currentMin = Math.min(current, currentMin * current);

            Maximum = Math.max (currentMax, Maximum);
        }
        return Maximum;
    }
}