class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int[] frequency= new int[26];
        int maxFreq =0;
        int LongestWindow = 0;

        int left = 0;
        for(int right = 0; right < n; right++){

            char rightChar = s.charAt(right);
            frequency[rightChar - 'A']++;

            maxFreq = Math.max(maxFreq, frequency[rightChar - 'A']);

            while((right-left+1) - maxFreq > k){
                char leftChar = s.charAt(left);
                frequency[leftChar - 'A']--;
                left++;
            }
            LongestWindow = Math.max(LongestWindow, right - left + 1);
        }
        return LongestWindow;
        

    }
}