class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        //METHOD 1:- USING TWO POINTERS
        if (sentence1.equals(sentence2))
            return true;

        String[] sen1= sentence1.split(" ");
        String[] sen2= sentence2.split(" ");

        int countWords= 0;
        int lenSen1= sen1.length, lenSen2= sen2.length;

        int i=0;
        while (i<Math.min(lenSen1,lenSen2)){
            if (sen1[i].equals(sen2[i]))
                countWords++;
            else
                break;
            i++;
        }

        int j= lenSen1-1;
        int k= lenSen2-1;
        while (j>=i && k>=i){
            if (sen1[j].equals(sen2[k]))
                countWords++;
            else
                break;
            j--; k--;
        }
        return countWords==Math.min(lenSen1,lenSen2);
        //TC is O(2*Math.min(m,n)) and SC is O(m+n)
    }
}