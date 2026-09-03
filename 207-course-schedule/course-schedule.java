class Solution {
    public boolean isCycleDFS(int src, int[][] pre, boolean[] vis, boolean[] rec){

        vis[src] = true;
        rec[src] = true;

        for(int i =0 ;i<pre.length; i++){

            int u = pre[i][0];
            int v = pre[i][1];

            if(u == src){
                if(!vis[v]){

                    if(isCycleDFS(v, pre, vis, rec)){
                        return true;
                    }
                }else if(rec[v]){
                    return true;
                }
            }    
        }
        rec[src] = false;
        return false; 
    }
    public boolean canFinish(int n, int[][] pre) {
        
        boolean[] vis = new boolean[n];
        boolean[] rec = new boolean[n];

        for(int i = 0; i<n; i++){
            
            if(!vis[i]){
                if(isCycleDFS(i, pre, vis, rec)){
                    return false;
                }
            }
        }
        return true;
    }
}