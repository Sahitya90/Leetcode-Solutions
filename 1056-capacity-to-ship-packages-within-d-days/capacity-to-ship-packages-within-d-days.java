class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int max = 0;
        int sum = 0;

        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
            w++;
        }
        int low = max;
        int high = sum;

        while(low<high){

            int mid = low + (high - low)/2;

            if(move( weights, mid, days)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean move(int[] weights, int mid, int days){
        
        int D = 1;
        int sum = 0;

        for(int i : weights){

            if(i + sum <= mid){
                sum += i;
            }
            else{
                sum = i;
                D++;
            }
        }
        return D<=days;
    }
}