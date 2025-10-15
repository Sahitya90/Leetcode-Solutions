class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> Set = new HashMap<>();

        Set.put('I', 1);
        Set.put('V', 5);
        Set.put('X', 10);
        Set.put('L', 50);
        Set.put('C', 100);
        Set.put('D', 500);
        Set.put('M', 1000);

        int total = Set.get(s.charAt(s.length() -1));

        for(int i = s.length() -2; i>=0; i--){

            int currentValue = Set.get(s.charAt(i));
            int rightValue = Set.get(s.charAt(i+1));


            if(currentValue < rightValue){
                total -= currentValue;
            }else{
                total += currentValue;
            }
        }
        return total;

    }
}