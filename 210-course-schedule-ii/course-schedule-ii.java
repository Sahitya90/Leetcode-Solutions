class Solution {

    public boolean dfs(int curr, boolean[] vis, boolean rec[], List<List<Integer>> graph, Stack<Integer> stack){

        vis[curr] = true;
        rec[curr] = true;

        for(int f : graph.get(curr)){

            if(rec[f]){
                return true;
            }else if(!vis[f]){
                if(dfs(f, vis, rec, graph, stack)){
                    return true;
                }
            }
        }
        rec[curr]= false;
        stack.add(curr);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int courses = pre[0];
            int requirement = pre[1];
            graph.get(requirement).add(courses);

        }
        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        

        for(int i = 0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i, vis, rec, graph, stack)){
                    return new int[]{};     
                    
                }
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        while(!stack.isEmpty()){
            result[i] = stack.pop();
            i++;
        }
        return result;
    }
}