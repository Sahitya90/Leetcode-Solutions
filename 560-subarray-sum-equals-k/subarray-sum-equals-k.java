class Solution {
    public int subarraySum(int[] nums, int k) {
        

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i = 1; i< nums.length; i++){

            prefixSum[i]= nums[i] + prefixSum[i-1];
        }

        for(int j = 0; j< nums.length; j++){
            
         if(prefixSum[j] == k){
            count++;
            
           }
           int value =  prefixSum[j] - k;

           if(map.containsKey(value)){
             count += map.get(value);
           }
           map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
           }
        
        return count;
        }
        
    }
