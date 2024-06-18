class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         // Sort workers based on their ability
        Arrays.sort(worker);

        int n = difficulty.length;
        Job[] store = new Job[n];
        for (int i = 0; i < n; i++) {
            store[i] = new Job(difficulty[i], profit[i]);
        }

        // Sort jobs based on difficulty
        Arrays.sort(store, (a, b) -> a.difficulty - b.difficulty);

        int totalProfit = 0;
        int jobIndex = 0;
        int maxProfit = 0;

        for (int ability : worker) {
            while (jobIndex < n && store[jobIndex].difficulty <= ability) {
                maxProfit = Math.max(maxProfit, store[jobIndex].profit);
                jobIndex++;
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}

class Job{
    int difficulty;
    int profit;
    public Job(int difficulty, int profit){
        this.difficulty= difficulty;
        this.profit= profit;
    }
}