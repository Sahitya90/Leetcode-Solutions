class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int c: s.toCharArray()){
            count[c - 'a'] ++;
        }
        for(int c : t.toCharArray()){
            count[c - 'a'] --;
        }
        for(int val : count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}