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
    public ListNode middleNode(ListNode head) {
        //USING TWO LOOOPS
        /*
        //First we will find the total number of nodes in LL
        ListNode p= head;
        int c=0;
        while (p != null){
            c++;
            p= p.next;
        }

        //Then we will run node till n/2
        int check=0;
        ListNode q= head;
        while (check<c/2){
            q= q.next;
            check++;
        }
        return q;
        */

        //TORTOISE AND HARE ALGORITHM
        //Using tortoise and hare algorithm
        //When fast willreach the end of LL then slow will be at middle
        //because slow is incremented by 1 and fast is incremented by 2
        ListNode slow= head, fast= head;
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}