class Solution {
    public int largestAltitude(int[] gain) {
        int maximum = 0;
        int currentSum = 0;

        for(int i = 0; i<gain.length; i++){
            currentSum += gain[i];
            if(maximum<currentSum){
                maximum = currentSum;
            
            }
        }
        return maximum;
    }
}