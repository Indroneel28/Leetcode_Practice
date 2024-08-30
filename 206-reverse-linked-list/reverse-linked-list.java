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
    public ListNode reverseList(ListNode head) {
        //METHOD 1:- ITERATIVE METHOD
        ListNode curr= head, prev= null;
        while (curr!=null){
            ListNode temp= curr.next; //Store next node
            curr.next= prev; //Changing direction
            prev= curr; //Update prev for next iteration
            curr= temp; //Move forward
        }
        //Now, curr is null and prev is the head of the reversed LL
        return prev;
        //TC is O(n) and SC is O(1)
    }
}