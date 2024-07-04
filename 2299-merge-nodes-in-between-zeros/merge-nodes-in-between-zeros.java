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
    public ListNode mergeNodes(ListNode head) {
        //If no nodes or one node(whose value is 0) is there in the LL then return null
        if(head==null || head.next==null)
            return null;
        //Given, "There are no two consecutive nodes with Node.val == 0."

        ListNode newHead= new ListNode(-1);
        ListNode storeHead= newHead;
        ListNode x= head.next; //Skipping head because head's value is 0
        int sum=0;
        while (x != null){
            sum+=x.val;
            if(x.val==0){
                ListNode node= new ListNode(sum);
                newHead.next= node;
                newHead= newHead.next;
                sum=0;
            }
            x= x.next;
        }
        return storeHead.next;
    }
}