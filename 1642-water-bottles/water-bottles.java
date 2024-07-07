class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int countBottlesDrank= 0, remainingEmptyBottles= 0;
        while (numBottles!=0){
            countBottlesDrank+= numBottles;
            int newFullBottles= (numBottles+remainingEmptyBottles)/ numExchange;
            remainingEmptyBottles= (numBottles+remainingEmptyBottles)%numExchange;
            numBottles= newFullBottles;
        }
        return countBottlesDrank;
    }
}