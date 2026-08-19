class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() >  s2.length()){
            return false;
        }
        
        int k = s1.length();

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i =0; i<k; i++){
            a1[s1.charAt(i) - 'a'] ++;

        }
        for(int right = 0; right<s2.length(); right++){
            a2[s2.charAt(right) -'a'] ++;
            
            if(right >= k){
                a2[s2.charAt(right-k) - 'a']--;
            }

            if(Arrays.equals(a1, a2)){
                return true;
            }
        }
        return false;
    }
}