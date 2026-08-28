class Solution {
    public String minWindow(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        int have = 0;
        int need = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int left = 0;
        int[] a1 = new int[128];
        int[] a2 = new int[128];

        for(int i = 0; i<n; i++){
            char a = t.charAt(i);
            if(a1[a] == 0){
                need++;
            }
            a1[a]++;

        }
        for(int right = 0; right<m; right++){

            char val = s.charAt(right);
            
            a2[val]++;


            if(a1[val] > 0 && a1[val] == a2[val]){
                have++;
            }
            while(need == have){

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    startIndex = left;
                }
                a2[s.charAt(left)]--;
                if(a1[s.charAt(left)] > 0 && a2[s.charAt(left)] < a1[s.charAt(left)]){
                    have--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}