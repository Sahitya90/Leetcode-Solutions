class Solution {
    
    //this dfs function here is to check whether there is a cycle or not
    public boolean dfs(int curr, boolean vis[], boolean rec[], List<List<Integer>> graph){

        vis[curr] = true;
        rec[curr] = true;

        for(int neighbour : graph.get(curr)){

            if(rec[neighbour]){
                //if already in the rec array, then cycle found
                return true;
            }else if(!vis[neighbour]){
                //if not visited, then recursive call
                if(dfs(neighbour, vis, rec, graph)){
                    //if found cycle wihtin then, return true
                    return true;
                }
            }
        }
        //if no cycle found for all the neighbours starting from curr, then remove curr from the rec array to further prevent the confusion for the function
        rec[curr] = false;
        //return false as cycle found till last
        return false;

    }
    //this function tells whether we can finish the course or not
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        //creating graph using arraylist or arraylist
        List<List<Integer>> graph = new ArrayList<>();

        //traversing to intialize how many number of elements will be there in the graph list
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        
        //add, the neighbour for a particular node into its assigned arraylist
        for(int[] pre : prerequisites){
            int course = pre[0];
            int requirement = pre[1];

            graph.get(requirement).add(course);
        }

        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];

        
        //decide how many times does the dfs function goes on for
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