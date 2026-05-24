class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) return Collections.singletonList(0);

        // ✅ HashSet instead of ArrayList for O(1) remove
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<>());
        }

        for(int[] e : edges){
            int n1 = e[0];
            int n2 = e[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                int neighbour = graph.get(leaf).iterator().next();
                graph.get(neighbour).remove(leaf); // ✅ no casting needed
                if(graph.get(neighbour).size() == 1){
                    newLeaves.add(neighbour);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}