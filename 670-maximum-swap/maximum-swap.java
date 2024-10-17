class Solution {
    public int maximumSwap(int num) {
        //BRUTE FORCE METHOD
        StringBuilder str= new StringBuilder();
        str.append(num);

        for (int i=0; i<str.length(); i++){
            char c= str.charAt(i);
            char max= c; int maxIndex= i;
            for (int j=i+1; j<str.length(); j++){
                if (str.charAt(j)>=max) {
                    max = str.charAt(j);
                    maxIndex= j;
                }
            }
            if(max>c){
                //swap characters between i and maxIndex
                str.setCharAt(maxIndex,c);
                str.setCharAt(i,max);
                break; //Atmomst only one swap
            }
        }
        return Integer.parseInt(str.toString());
        //TC is O(n^2) and SC is O(n)
    }
}