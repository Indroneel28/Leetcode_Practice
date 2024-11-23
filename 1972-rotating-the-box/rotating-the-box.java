class Solution {
    public char[][] rotateTheBox(char[][] box) {
        //OPTIMAL METHOD:- RIGHT ROTATE AND THEN TRANSPOSE
        for (int i=0; i<box.length; i++){
            int lastStone= -1;
            for (int j=0; j<box[0].length; j++){
                char c= box[i][j];
                if (c=='#'){
                    if (lastStone==-1)
                        lastStone= j;
                }
                else if (c=='*'){
                    lastStone= -1;
                }
                else {
                    //c=='.'
                    if (lastStone!=-1){
                        //The object falls down (means goes right)
                        box[i][j]= '#';
                        box[i][lastStone]= '.';
                        lastStone++;
                    }
                }
            }
        }
        
        //Return the transpose
        char[][] transpose= new char[box[0].length][box.length];
        for (int i=0; i<box.length; i++){
            for (int j=0; j<box[0].length; j++){
                transpose[j][box.length-1-i]= box[i][j];
            }
        }
        return transpose;
        
        //TC is O(2*m*n) and SC is O(m*n)
    }
}