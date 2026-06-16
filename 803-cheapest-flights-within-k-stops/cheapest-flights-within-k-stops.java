class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
     
        int[] original = new int[n];
        int INF = (int) 1e9;
        Arrays.fill(original, INF);
        original[src]= 0;


        for(int i = 0; i<=k; i++){
            int[] temp = Arrays.copyOf(original, n);

        for(int[] flight : flights){

            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            if(original[u] != INF){

            if(original[u] + price < temp[v]){
                temp[v] = original[u] + price;
            }
        }   
        }
        original = temp;
        }
        return original[dst] == INF ? -1 : original[dst];

        
    }
}