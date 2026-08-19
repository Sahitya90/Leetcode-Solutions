class Solution {
    public String minWindow(String s, String t) {
        
        int m = s.length();
        int n = t.length();

        int[] a1 = new int[128];
        int[] a2 = new int[128];
        int have = 0;
        int need = 0;
        int minWin = Integer.MAX_VALUE;
        int startIndex = -1;

        for(char c: t.toCharArray()){
            if(a1[c] == 0){
                need++;
            }
            a1[c]++;
        }
        int left = 0;
        
        for(int right = 0; right<m; right++){

            char val = s.charAt(right);
            a2[val]++;

            if( a1[val] > 0 && a1[val] == a2[val]){
                have++;
            }

            while(have == need){
                //store the value of minWin, in the case it is less than current minWin, also store the startPostion on left 

                if(right - left + 1 < minWin){
                    minWin = right -left + 1;
                    startIndex = left;

                }
                //shrink the left element
                char leftChar = s.charAt(left);
                a2[leftChar]--;

                //on shrinking if the frequency of both arrays get unequal we reduce the value have              
                if(a1[leftChar] > 0 && a2[leftChar] < a1[leftChar]){
                    have--;
                }

                //move the left pointer forward
                left++;
            }
                
        }
        return minWin == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minWin);

    }
}