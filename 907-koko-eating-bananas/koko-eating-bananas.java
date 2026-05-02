class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;
        
        for(int num : piles){
            if(num > high){
                high = num;
            }
        }

        while(low < high){
            int mid = low + (high - low) /2;

            if (hoursNeeded(piles, mid) > h){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public int hoursNeeded(int[] piles, int speed){
        int hours = 0;
        for(int p : piles){
            hours += Math.ceil((double)p/speed);

        }
        return hours;
    }
}