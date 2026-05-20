class Solution {

    public boolean dfs(int curr, boolean vis[], boolean rec[], List<List<Integer>> graph){

        vis[curr] = true;
        rec[curr] = true;

        for(int neighbour : graph.get(curr)){

            if(rec[neighbour]){
                return true;
            }else if(!vis[neighbour]){
                if(dfs(neighbour, vis, rec, graph)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }


        for(int[] pre : prerequisites){
            int course = pre[0];
            int requirement = pre[1];

            graph.get(requirement).add(course);
        }

        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(vis[i]==false){
                if(dfs(i, vis, rec, graph)){
                    return false;
                }
            }
        }
        return true;
    }
}