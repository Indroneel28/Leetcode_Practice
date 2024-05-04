class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //Greedy Approach- Sorting and using two pointers
        //Fractional Kanpsack type question
        Arrays.sort(people);

        int start=0, stop= people.length-1;
        int count=0;
        while (start<=stop){
            if (people[start]+people[stop]<=limit) {
                count++;
                start++; stop--;
            }
            else if (people[stop]<=limit){
                count++;
                stop--;
            }
        }
        return count;
    }
}