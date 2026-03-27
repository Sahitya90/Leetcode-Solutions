class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1, -1};

        if(nums.length ==0){
            return result;
        }
        
        result[0] = First(nums, target);
        result[1] = Last(nums, target);

        return result;


    }

    public int First(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while(left<=right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                result = mid;
                right = mid-1;
            }
            else if (nums[mid]< target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return result;
    }
    public int Last(int[] nums, int target){
        int left = 0; 
        int right = nums.length -1;
        int result = -1;

        while(left<=right){
            int mid = left + (right - left) / 2;

            if(nums[mid]== target){
                result = mid;
                left = mid +1;
            }
            else if (nums[mid]<target){
                left = mid + 1;

            }
            else{
                right = mid -1;
            }
        }
        return result;
    }

}