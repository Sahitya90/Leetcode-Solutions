class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];
        int count = 0;

        prefixSum[0] = nums[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int j = 0; j<n; j++){
            
            int val = prefixSum[j] % k;
            if(val % k == 0){
                count++;
            }
            if (val < 0) {
    val += k; 
}
            if(map.containsKey(val)){

                count += map.get(val);
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return count;
    }

}