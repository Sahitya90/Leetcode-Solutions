class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        while(low < high){
            int mid = low + (high-low)/2;

            if(nums[mid]<nums[mid+1]){
                //on the right side
                low = mid+1;
            }
            else{
                //on the low side
                high = mid;
            }
        }
        return low; //because at this place low and high will become same
    }
}