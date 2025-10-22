class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i<nums.length; i++){
            int c = nums[i];

            if(set.contains(c)){
                return true;
            }

            set.add(c);
            
            
            
        }
        return false;
        
    }
}