class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n !=0){
            //then we apply and operator on n
            if((n&1) == 1){
                count++;
            }
            //logical right shift 'n' by 1
            n = n >>> 1;
        }
        return count;
    }
}