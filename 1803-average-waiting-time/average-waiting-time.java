class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime= 0;
        int last= customers[0][0];
        for (int[] arr: customers){
            if (arr[0]>last)
                last= arr[0];
            last+= arr[1];
            totalWaitingTime+= (last-arr[0]);
        }
        return totalWaitingTime/customers.length;
    }
}