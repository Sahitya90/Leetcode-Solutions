class Solution {
    public boolean judgeCircle(String moves) {
        Map <Character, int[]> Coordinates = new HashMap<>();

        Coordinates.put('R',new int[]{1,0});
        Coordinates.put('L',new int[]{-1,0});
        Coordinates.put('U',new int[]{0,1});
        Coordinates.put('D',new int[]{0,-1});

        int[] position = new int[]{0,0};

        for(int i =0; i<moves.length();  i++){
            char c = moves.charAt(i);
            int[] move = Coordinates.get(c);

            position[0] += move[0];
            position[1] += move[1];

           
           

        }if(position[0] == 0 && position[1]==0){
            return true;
        }
        else{
            return false;
        } 
    }
}