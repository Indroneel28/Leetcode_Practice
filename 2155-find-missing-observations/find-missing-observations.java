class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        //USING PEN AND PAPER AND LOGIC
        int m= rolls.length;

        int sum= 0;
        for (int roll: rolls)
            sum+= roll;

        int sumOfN= mean * (m+n) - sum;

        //Not possible case
        if (n > sumOfN || (float)sumOfN/n > 6) //Not fitting in 1 to 6
            return new int[]{};
        
        //Possible case
        int[] answer= new int[n];
        int avg= sumOfN/n;
        for (int i=0; i<n; i++)
            answer[i]= avg;
        
        int leftOver= sumOfN-(avg*n);
        int i= 0;
        while (leftOver>0){ //will execute less than 6 times
            answer[i]++;
            i++;
            leftOver--;
        }
        return answer;
        //TC is O(m + n) and Sc is O(n)
    }
}