class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum= 0;
        for (int j=0, i=happiness.length-1; j<k; j++,i--){
            if (happiness[i]-j < 0)
                break;
            sum+= (happiness[i]-j);
        }
        return sum;
    }
}