class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int count = 0;
        Arrays.sort(tokens);

        int i=0, j=tokens.length-1;
        while (i<=j){
            if (tokens[i]<=power){
                count++;
                power-= tokens[i];
                i++;
            }
            else if (i<j && count>=1){
                power+=tokens[j];
                count--;
                j--;
            }
            else
                break;
            System.out.println(power);
        }
        return count;
    }
}