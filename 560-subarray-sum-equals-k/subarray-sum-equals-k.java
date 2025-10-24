class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map =  new HashMap<>();

        int counter = 0;

        int currSum = 0;

        map.put(0, 1);

        for(int num : nums){

            currSum += num;

            int prevSum = currSum -k;

            

            if(map.containsKey(prevSum)){
                counter += map.get(prevSum); 
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        }
        return counter;
    }
}