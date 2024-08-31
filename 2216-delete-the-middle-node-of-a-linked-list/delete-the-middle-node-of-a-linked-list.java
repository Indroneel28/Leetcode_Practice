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
    public ListNode deleteMiddle(ListNode head) {
        //BRUTE FORCE METHOD
        //COUNT NUMBER OF NODES
        //TRAVERSE TILL COUNT/2 - 1 (THE ELEMENT BEFORE THE MIDDLE ELEMENT)
        //DELETE THE NEXT ELEMENT WHICH WILL BE THE MIDDLE
        //TC is O( n + n/2) and SC is O(1)

        //OPTIMAL METHOD :- USING ADVANCE TORTOISE-HOARE ALGORITHM

        //Edge Case for no nodes or only one node in LL
        if (head==null || head.next==null)
            return null; //If one node then it will be deleted

        //We will find the element before the middle element
        ListNode slow= head, fast= head.next.next; //fast is given a headstart
        //No dummy variable like prev required
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        //slow is storing the element before the middle element
        slow.next= slow.next.next; //skip middle element
        return head;
        //TC is O(n/2) and SC is O(1)
    }
}