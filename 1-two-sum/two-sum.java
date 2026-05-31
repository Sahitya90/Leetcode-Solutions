class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){

            int current = target - nums[i];

            if(map.containsKey(current)){
                return new int[]{map.get(current), i};
            }
            
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}