class Solution {
    public int subarraySum(int[] nums, int k) {
         int count = 0 ;
         int currentSum = 0;
         int n = nums.length;

         //creating the map
         Map<Integer, Integer> map = new HashMap<>();
         
         int[] prefixSum = new int[n];
         prefixSum[0] = nums[0];

         //filling the prefixSum array
         for(int i = 1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
         } 


         //looping n, times
         for (int j = 0; j<n; j++){
            if(prefixSum[j]==k){
                count++;
            }
            Integer val = prefixSum[j] - k;

            if(map.containsKey(val)){

                count += map.get(val);
            }
            map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
         }
         return count;



    }
}