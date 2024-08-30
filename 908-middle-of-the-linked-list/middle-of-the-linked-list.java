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
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        //First we will find the total number of nodes in LL
        ListNode p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }

        //Then we will run node till n/2
        int check = 0;
        ListNode q = head;
        while (check < c / 2) {
            q = q.next;
            check++;
        }
        return q;
        */
        //TC IS O(N/2 + N) AND SC IS O(1)
        
        //METHOD 2:- OPTIMAL METHOD USING TORTOISE HOARE ALGORITHM
        ListNode fast= head, slow= head;
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
        //TC is O(N/2) and SC is O(1)
    }
}