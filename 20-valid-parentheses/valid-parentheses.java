class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> Set = new HashMap<>();

        Set.put('(',')');
        Set.put('{','}');
        Set.put('[',']');

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Set.containsKey(c)){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char lastOpen = stack.pop();

                if(Set.get(lastOpen) != c){
                    return false;
                }
            }
        }
        
        
        

        return stack.isEmpty();
    }
}