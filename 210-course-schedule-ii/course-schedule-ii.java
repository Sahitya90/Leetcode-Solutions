class Solution {
    public int[] findOrder(int n, int[][] pre) {


        List<List<Integer>> graph = new ArrayList<>();
        int[] result = new int[n];
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : pre){

            int courses = p[0];
            int requirement = p[1];
            graph.get(requirement).add(courses);
            indegree[courses]++;
        }

        
        int r = 0;
        
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            result[r] = curr;
            r++;

            for(int neighbour : graph.get(curr)){
                
                indegree[neighbour]--;
                
                
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
                } 
            }
            if (r != n) {
            return new int[0];
         }return result;
           
        }
        
         
    }
