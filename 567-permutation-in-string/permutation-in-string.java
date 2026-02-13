class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> map = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();

         if (n1 > n2) return false;

        for (char c : s1.toCharArray()){

            map.put(c, map.getOrDefault(c, 0) +1);
        }

        //hashmap to store the elements of string 2

        Map<Character, Integer> windowMap = new HashMap<>();

        //here we create the fixed window

        for(int i = 0; i < n1; i++){
            char c= s2.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c,0) +1);
        }

        //checks if the "map"  is same as "windowMap"
        if(map.equals(windowMap)) return true;

        // now we have got the result statement that elements of string 1 are there in string 2 
    

        //here we use the sliding window approach
        //in the sliding window logic, we move forward and at the same time decrement the first one

        int left = 0;
        for(int right = n1; right<n2; right++){

            //add the new element
            char newChar = s2.charAt(right);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) +1);

            //remove the old char or the character where left points to
            char oldChar = s2.charAt(left);
            windowMap.put(oldChar, windowMap.get(oldChar) - 1);

            //if the frequency for a element becomes 0 we remove it 

            if(windowMap.get(oldChar)==0){
                windowMap.remove(oldChar);
            }
            left++;

            //here we check the equivalence of map and windowMap

            if(map.equals(windowMap)){
                return true;
            }

           
        }
         return false;
    
}
}