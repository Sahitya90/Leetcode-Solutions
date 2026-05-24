class Solution {

    public boolean dfs(int curr, boolean[] vis, boolean[] rec, boolean[] safe, int[][] graph){

        vis[curr] = true;
        rec[curr] = true;

        for(int neighbour : graph[curr]){

            if(rec[neighbour]){
                return true;
            }else if(!vis[neighbour]){
                if(dfs(neighbour, vis, rec, safe, graph)){
                    return true;
                }
            }
        }
        rec[curr]= false;
        safe[curr] = true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        
        int n = graph.length; //no. of nodes
        
        boolean vis[] = new boolean[n];
        boolean rec[] = new boolean[n];
        boolean[] safe = new boolean[n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i <n; i++){
            if(!vis[i]){
                dfs(i, vis, rec, safe, graph);
            }
        }
        for(int i = 0; i< n; i++){
            if(safe[i]){
            result.add(i);
        }
        }
        return result;
    }  
}
