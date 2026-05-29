class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        int length = nums.length;

        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }
        int size = set.size();

        if(size < length){
            return true;
        }else{
            return false;
        }
    }
}