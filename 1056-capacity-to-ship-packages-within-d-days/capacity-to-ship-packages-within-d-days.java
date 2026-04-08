class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        int max = 0;

        for(int i = 0; i<weights.length; i++){
            if(weights[i]>max){
                max = weights[i];
            }
            sum += weights[i];
        }
        int low = max;
        int high = sum;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(ship(weights, days, mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;

    }
    private boolean ship(int[] weights, int days, int mid){

        int D =1;
        int sum = 0;

        for(int i : weights){
            if(i + sum <= mid){
                sum += i;
            }else{
                sum = i;
                D++;
            }
        }
        return D <= days;
    }
}