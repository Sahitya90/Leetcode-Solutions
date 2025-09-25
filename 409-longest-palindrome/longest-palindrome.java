class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer>counts = new HashMap<>();

        for(char c : s.toCharArray()){
            counts.put(c, counts.getOrDefault(c,0)+1);
        }
        int length = 0;

        for(int char1 : counts.values()){
                length += (char1 / 2)*2;
        }

        if(length < s.length()){
            length ++;
        }

        return length;

        
    }
}
