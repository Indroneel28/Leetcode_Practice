class Solution {
    public String frequencySort(String s) {
        //METHOD 2:- USING ARRAY
        int[] arr= new int[128];
        for (int i=0; i<s.length(); i++){
            int c= s.charAt(i);
            arr[c]++;
        }
        String answer="";
        while (true){
            int count= 0, index=0;
            //Finding character having max frequency
            for (int i=0; i<arr.length; i++){
                if (arr[i]>count) {
                    count = arr[i];
                    index= i;
                }
            }
            if (count==0) //All conditions executed
                break;
            arr[index]= 0;
            for (int i=1; i<=count; i++)
                answer+=(char)(index);
        }
        return answer;
    }
}