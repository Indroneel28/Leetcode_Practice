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
    ListNode prev;
    public ListNode reverseList(ListNode head) {

        //ITERATIVE METHOD
        // ListNode curr= head;
        // ListNode prev= null;
        // while (curr != null){
        //     ListNode temp= curr.next;
        //     curr.next= prev;
        //     prev= curr;
        //     curr= temp;
        // }
        // head= prev;
        // return head;

        //RECURSIVE METHOD
        if (head==null)
            return prev;
        ListNode temp= head.next;
        head.next= prev;
        prev= head;
        head= temp;
        return reverseList(head);
    }
}