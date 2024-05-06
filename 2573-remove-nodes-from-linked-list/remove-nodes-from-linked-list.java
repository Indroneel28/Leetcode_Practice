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
    public ListNode reverse(ListNode node){
        ListNode curr= node, prev= null;
        while (curr!=null){
            ListNode temp= curr.next;
            curr.next= prev;
            prev= curr;
            curr= temp;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        ListNode rev= reverse(head);
        ListNode newHead= new ListNode(-1);

        int max= 0;
        ListNode p= rev, q= newHead; //p and q are pointers
        while (p!=null){
            if (p.val>=max){
                q.next= new ListNode(p.val);
                q= q.next;
                max= p.val;
            }
            p= p.next;
        }
        return reverse(newHead.next);

        //WE CAN ALSO SOLVE IT WITH STACK LIKE INSERTING ALL NODES IN STACK AND RETRIEVING OUT AND COMPARING WITH MAX
        //IF > MAX THEN WE WILL ADD IN THE BEGINNING OF THE LL AND AT LAST RETURN LL WHEN STACK IS EMPTY
    }
}