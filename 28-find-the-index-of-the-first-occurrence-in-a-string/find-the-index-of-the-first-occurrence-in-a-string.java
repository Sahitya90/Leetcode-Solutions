class Solution {
    public int strStr(String haystack, String needle) {

        int m = needle.length();
        int n = haystack.length();
        for(int window  = 0; window <= n-m; window++){

            int i =0;
            while(i<m && haystack.charAt(window + i) == needle.charAt(i)){
                i++;
            }
            if(i==m){
                return window;
            }

           
        }
        return -1;
    }

}