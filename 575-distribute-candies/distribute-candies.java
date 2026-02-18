class Solution {
    public int distributeCandies(int[] candyType) {
        
        int n = candyType.length;

        int maximumCandy = n/2;

        Set<Integer> uniqueCandies = new HashSet<>();

        for(int candy : candyType){

            uniqueCandies.add(candy);
        }
        return Math.min(maximumCandy, uniqueCandies.size());
    }
}