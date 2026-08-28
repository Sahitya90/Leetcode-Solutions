class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int n = s.length();
        int maxFreq = 0;
        int[] freq = new int[126];
        int win = Integer.MIN_VALUE;

        for(int right = 0; right< n; right++){

            char c = s.charAt(right);
            freq[c]++;
            maxFreq = Math.max(maxFreq, freq[c]);


            while((right - left + 1) - maxFreq > k){
                char l = s.charAt(left);
                freq[l]--;
                left++;
            }
            win = Math.max(win, right - left + 1);
        }
        return win;
    }
}