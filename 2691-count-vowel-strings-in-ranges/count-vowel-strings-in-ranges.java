class Solution {
    private boolean checkVowel(String s){
        char c= s.charAt(0), e= s.charAt(s.length()-1);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') && (e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u');
    }
    public int[] vowelStrings(String[] words, int[][] queries) {

        //OPTIMAL METHOD:- PREFIX SUM

        //Count number of vowel words
        int[] prefixSum= new int[words.length];
        int prev= 0;
        for (int i=0; i<words.length; i++){
            if (checkVowel(words[i])){
                prev++;
            }
            prefixSum[i]= prev;
        }

        //Check the queries now
        int[] answer= new int[queries.length];
        int i= 0;
        for (int[] query: queries){
            int start= query[0], end= query[1];
            if (start-1<0)
                answer[i]= prefixSum[end];
            else
                answer[i]= prefixSum[end]-prefixSum[start-1];
            i++;
        }
        return answer;
    }
}