class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) return Collections.singletonList(0);
        List<List<Integer>> graph = new ArrayList<>();

        //to create a list at each index of adjancency list
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        // to store the value at each index of edges in the adjancency list
        for(int[] e : edges){
            int n1 = e[0];
            int n2 = e[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }


        // to find the nodes that are leaves
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }
        // to trim these leaves until 2 or fewer nodes remain
        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes = remainingNodes - leaves.size();
            List<Integer> newLeave = new ArrayList<>();
            for(int leaf : leaves){
                int neighbour = graph.get(leaf).iterator().next();
                graph.get(neighbour).remove(Integer.valueOf(leaf));

                if(graph.get(neighbour).size() == 1){
                    newLeave.add(neighbour);
                }
            }
            leaves = newLeave;
            
        }
        return leaves;


    }
}