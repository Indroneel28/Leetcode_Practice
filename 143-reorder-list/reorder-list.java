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
    public void reorderList(ListNode head) {
        //Let's solve this without using any extra space

        //First we will traverse the Linked List using slow pointer and fast pointer to find the middle of the LinkedList
        ListNode slow= head, fast= head;
        while (fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode prevOfSlow= slow;
        slow= slow.next;
        prevOfSlow.next=null;

        //Now, we will reverse the LinkedList from middle
        ListNode prev= null;
        while (slow!=null){
            ListNode temp= slow.next;
            slow.next= prev;
            prev= slow;
            slow= temp; //Will traverse the LL
        }
        //After termination of the loop, prev is storing the last node

        //Now, Let's solve it
        //We are not using any extra space
        ListNode p= head, q= prev;
        while (q!=null){ //Don't use p!=null
            ListNode temp= p.next, temp2= q.next;
            p.next= q;
            q.next= temp;
            p= temp; q= temp2;
        }
    }
}