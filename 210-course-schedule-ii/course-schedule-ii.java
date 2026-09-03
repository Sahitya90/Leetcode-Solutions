class Solution {
    public int[] findOrder(int n, int[][] pre) {

        int[] result = new int[n];
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int r = 0;
        
        for(int[] p : pre){

            int u = p[0];
            int v = p[1];
            indegree[u]++;
        }

        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            result[r] = (curr);
            r++;

            for(int[] p : pre){

                if(p[1] == curr){
                    indegree[p[0]]--;
                
                
                if(indegree[p[0]] == 0){
                    q.add(p[0]);
                }
                }
            }
        }
        if (r != n) {
            return new int[0];
         }
        return result; 
    }
}