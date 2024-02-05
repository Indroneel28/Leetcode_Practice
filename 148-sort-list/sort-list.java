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
        if(head==null || head.next==null) //If LL contain only one node or zero nodes
            return head;

        PriorityQueue<Integer> queue= new PriorityQueue<>();
        while (head!=null){
            queue.add(head.val);
            head= head.next;
        }

        ListNode newHead= new ListNode(-1);
        ListNode p= newHead;
        while (!queue.isEmpty()){
            ListNode node= new ListNode(queue.remove());
            p.next= node;
            p= node;
        }
        return newHead.next; //avoiding -1 element
    }
}