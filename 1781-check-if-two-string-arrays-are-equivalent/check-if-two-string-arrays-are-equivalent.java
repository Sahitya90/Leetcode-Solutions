class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(int i = 0; i<word1.length; i++){
            
            a.append(word1[i]);
        }
        for(int j = 0; j<word2.length; j++){

            b.append(word2[j]);
        }
        String first = a.toString();
        String second = b.toString();

        
        return first.equals(second);
    }
}