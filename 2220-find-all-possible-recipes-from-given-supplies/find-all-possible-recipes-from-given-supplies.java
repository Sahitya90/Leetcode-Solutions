class Solution {
    
    public boolean dfs(int curr, boolean[] vis, boolean[] rec, boolean[] canMake, Map<String, Integer> recipeIndex, List<List<String>> ingredients,Set<String> supplySet){

        if(rec[curr]) return false;
        if(vis[curr]) return canMake[curr];

        vis[curr]= true;
        rec[curr]= true;

        for(String ingredient : ingredients.get(curr)){

            // ingredient is in supplies list
            if(supplySet.contains(ingredient)){
                continue;
            }

            //ingredient is not in the recipe list
            if(!recipeIndex.containsKey(ingredient)){
                rec[curr] = false;
                return false;
            }
            
            //ingredient is in the recipe list, now we check if it can be made
            if(!dfs(recipeIndex.get(ingredient), vis, rec, canMake, recipeIndex, ingredients, supplySet)){
                rec[curr] = false;
                return false;
            }
        }
        rec[curr] = false;
        canMake[curr] = true; // all ingredients available recipe is makeable
        return true;


    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        

        // put all supplies in a set for O(1) lookup
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

        Map<String, Integer> recipeIndex = new HashMap<>();

        int n = recipes.length;
        boolean[] vis = new boolean[n];
        boolean[] rec = new boolean[n];
        boolean[] canMake = new boolean[n];

        //map each recipe name to  its index
        for(int i = 0; i < n ; i++){
            recipeIndex.put(recipes[i], i);
        }

        //try to make every recipe
        List<String> result = new ArrayList<>();
        for(int i =0 ; i<n; i++){
            if(dfs(i, vis, rec, canMake, recipeIndex, ingredients, supplySet)) result.add(recipes[i]);
        }

        return result;
    }
}