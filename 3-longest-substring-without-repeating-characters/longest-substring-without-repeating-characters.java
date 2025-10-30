class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;

        int maxLength= 0;
        
        Set<Character> windowChars = new HashSet<>();

        for(int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if(windowChars.contains(c)){
                
                while(windowChars.contains(c)){
                  

                  windowChars.remove(s.charAt(left));

                  left++;
                }

            }
            windowChars.add(c);

            int Length = right-left+1;
            maxLength = Math.max(Length, maxLength);


        }
        return maxLength;
    }
}