class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int n = piles.length;
        Arrays.sort(piles);
        int r = piles[n-1];

        int result = r;

        while(l<=r){
           int k = l + (r-l)/2;
            long hours = 0;

            for(int p=0; p<n; p++){
                hours += Math.ceil((double) piles[p]/k);
            }
            if(hours <= h){
                    result = k;
                    r = k-1;
                }else{
                    l = k+1;
                }
        }
        return result;

    }
}