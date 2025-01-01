class Solution {
    public int maxScore(String s) {
        int maxScore= 0;
        for (int i=1; i<s.length(); i++){
            int count0= 0, count1= 0;
            for (int j=0; j<i; j++){
                if (s.charAt(j)=='0')
                    count0++;
            }
            for (int j=i;j<s.length(); j++){
                if (s.charAt(j)=='1')
                    count1++;
            }
            System.out.println("i is "+i+" count0 is "+count0+" count1 is "+count1);
            if (count0+count1>maxScore)
                maxScore= count0+count1;
        }
        return maxScore;
    }
}