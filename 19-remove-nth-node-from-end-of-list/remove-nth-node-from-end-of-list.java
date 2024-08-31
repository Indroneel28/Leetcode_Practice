/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //BRUTE FORCE METHOD
        //Count the number of nodes
        int count= 0;
        for (ListNode i=head; i!=null; i= i.next)
            count++;

        //Edge case:- Delete counth from right => Delete 1st Node i.e. head
        if (count==n)
            return head.next;

        //Difference
        int dif= count-n;

        ListNode prev= head;
        //Iterate before diff-1
        while (dif>1){
            dif--;
            prev= prev.next;
        }
        prev.next= prev.next.next;
        return head;
        //TC is O(count+ (count-n)) and SC is O(1)
    }
}