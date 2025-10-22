class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> list = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int c = nums[i];
            int d = target - c;

            if(list.containsKey(d)){
                return new int[] {list.get(d), i};
            }

            list.put(c, i);

        
        }
        
    throw new IllegalArgumentException("No two sum solution");
    }
}