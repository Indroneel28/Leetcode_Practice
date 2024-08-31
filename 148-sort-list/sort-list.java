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
    public ListNode sortList(ListNode head) {
        //BRUTE FORCE METHOD:- Using Priority Queue
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        for (ListNode i=head; i!=null; i= i.next)
            queue.add(i.val);
        for (ListNode i= head; i!=null; i= i.next)
            i.val= queue.poll();
        return head;
        //TC is O(2n) and SC is O(n)
    }
}