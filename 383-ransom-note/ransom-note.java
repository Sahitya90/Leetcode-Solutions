class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        

        Map<Character, Integer>counts = new HashMap<>();

        for(char c : magazine.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0)+1);
        }
        for(char c : ransomNote.toCharArray()){
            int countCharacter = counts.getOrDefault(c, 0);

            if(countCharacter == 0){
                return false;
            }
            counts.put(c, countCharacter -1);
        

            }
            return true;
        }
    }
