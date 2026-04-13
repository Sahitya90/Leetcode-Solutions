class Solution {
    public int[] countBits(int n) {
        //brute force
        int[] result = new int[n+1];
        for(int i = 0; i<=n;i++){
            int num = i;
            int count=0;

            //let num = 1101
            while(num != 0){
                count += num%2;
                num/=2;
            }
            result[i] = count;
            

        }
        return result;
    }
}