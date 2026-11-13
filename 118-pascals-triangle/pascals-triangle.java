class Solution {
    public List<List<Integer>> generate(int numRows) {
        

        List<List<Integer>> mainList = new ArrayList<>();


        List<Integer> baseCase = new ArrayList<>();
        baseCase.add(1);
        mainList.add(baseCase);


        for(int i = 1; i< numRows; i++){

            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = mainList.get(i-1);

            currRow.add(1);

            for(int j = 1; j< i; j++){

                int sum = prevRow.get(j-1) + prevRow.get(j);
                currRow.add(sum);
            }
            currRow.add(1);
            mainList.add(currRow);
        }
        return mainList;
    }
}