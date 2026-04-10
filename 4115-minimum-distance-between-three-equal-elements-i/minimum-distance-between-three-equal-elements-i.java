import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        
        int n = nums.length;
        Map<Integer, List<Integer>>map = new HashMap<>();

        for(int i = 0; i<n; i++){
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int result = Integer.MAX_VALUE;

        for(List<Integer>list : map.values()){
            if(list.size() >= 3){
                for(int i = 0; i+2<list.size(); i++){
                    int a = list.get(i);
                    int b = list.get(i+1);
                    int c= list.get(i+2);

                    int distance = Math.abs(a-b)+ Math.abs(b-c) + Math.abs(c-a);
                    result = Math.min(result, distance);
                }
            }
        }
        return result == Integer.MAX_VALUE ?-1 : result;       
        
    }
}