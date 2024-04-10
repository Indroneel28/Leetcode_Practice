class Solution {
    /*
Simulate the process with a queue.

Sort the deck, it is actually the "final sequence" we want to get according to the question.
Then put it back to the result array, we just need to deal with the index now!
Simulate the process with a queue (initialized with 0,1,2...(n-1)), now how do we pick the card?
We first pick the index at the top: res[q.poll()]=deck[i]
Then we put the next index to the bottom: q.add(q.poll());
Repeat it n times, and you will have the result array!
update
Let's walk through the example:
Input: [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]

Sort the deck: [2,3,5,7,11,13,17], this is the increasing order we want to generate
Initialize the queue: [0,1,2,3,4,5,6], this is the index of the result array
The first card we pick is res[0], observe the deck, it should be deck[0]==2, so assign res[0]=2
Then we put res[1] to the bottom, so we re-insert 1 to the queue
The second card we pick is res[2], which should be deck[1]==3, so assign res[2]=3
Then we re-insert 3 to the queue
Each time we assign 1 value to the res, so we repeat this n times.
Hope this helps.
    */
    public int[] deckRevealedIncreasing(int[] deck) {
        int n= deck.length;
        Arrays.sort(deck);
        Queue<Integer> q= new LinkedList<>();
        for (int i=0; i<n; i++) q.add(i);
        int[] res= new int[n];
        for (int i=0; i<n; i++){
            res[q.poll()]=deck[i];
            q.add(q.poll());
        }
        return res;
    }
}