class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // hashmap to store the element of nums1 and their indexes
        Map<Integer, Integer> map = new HashMap<>();

        //stack to hold values that appear in both lists
        Stack<Integer> stack = new Stack<>();

        for(int num: nums2){

            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);  //storing the value that has been popped as an id and the next greater element as the value
            }
            stack.push(num);  //push the value num in the stack
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i< nums1.length; i++){
            res[i]= map.getOrDefault(nums1[i], -1); // here we are putting the value 3 at the place of 1
        }
        return res;
    }
}