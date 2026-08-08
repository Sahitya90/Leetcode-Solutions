class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        
        int n = temperatures.length;
        int[] answer = new int[n];
        int hottest = 0;
        for(int i = n-1; i >= 0; i--){

                //if the stack is not empty, and if the head of the stack is less than the curent value in the array, then we need to pop that element from the stack
               

               if(temperatures[i] >= hottest){
                hottest = temperatures[i];
                continue;
               }

               int curr = i + 1;

                while(temperatures[curr] <=  temperatures[i]){
                    curr = curr + answer[curr];
                }
                answer[i]= curr -i;
            
        }
        return answer;
    }
}