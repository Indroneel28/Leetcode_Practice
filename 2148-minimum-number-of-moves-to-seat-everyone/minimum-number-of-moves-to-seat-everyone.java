class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        //Using the Greedy Strategy!!
        //Sorting both seats and students array
        Arrays.sort(seats);
        Arrays.sort(students);

        int sum= 0;
        for (int i=0; i<seats.length; i++){
            sum+= Math.abs(students[i]-seats[i]);
        }
        return sum;
    }
}