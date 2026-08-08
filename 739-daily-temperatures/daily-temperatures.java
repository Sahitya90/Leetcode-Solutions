class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i = n-1; i >= 0; i--){

                //if the stack is not empty, and if the head of the stack is less than the curent value in the array, then we need to pop that element from the stack
                while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                    s.pop();
                }

                if(!s.isEmpty()){
                    answer[i] = s.peek() - i;

                }
                s.push(i);
            
        }
        return answer;
    }
}