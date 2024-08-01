class Solution {
    public int countSeniors(String[] details) {
        //METHOD 1:- BRUTE FORCE METHOD
        /*
        int count= 0;
        for (String str: details){
            int age= Integer.parseInt(str.substring(11,13));
            if (age>60)
                count++;
        }
        return count;
         */
        //TC is O(N^2) AND SC is O(1)

        //METHOD 2:- USING BRAIN
        int count= 0;
        for (String str: details){
            char tens= str.charAt(11);
            char ones= str.charAt(12);
            
            int age= (tens-'0')*10 + (ones-'0');
            if (age>60)
                count++;
        }
        return count;
        //TC is O(N) AND SC is O(1)
    }
}