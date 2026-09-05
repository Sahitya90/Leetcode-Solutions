class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for(int i =1; i<=k+1; i++){

            int[] temp = dist.clone();
            for(int[] flight : flights){

                int a = flight[0]; //from
                int b = flight[1];  // to 
                int c = flight[2];  //price

                if(dist[a] == Integer.MAX_VALUE){
                    continue;
                }

            
                if(dist[a] + c < temp[b]){
                    temp[b] = dist[a] + c;
                }
            }
            dist = temp;
        }
        return dist[dst] ==  Integer.MAX_VALUE ? -1 : dist[dst];
    }
}