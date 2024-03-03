/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     nt val;
 *     ListNode next;
 *     ListNode() {}i
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //BEGINNER METHOD
        
        //First let's count the total number of nodes in the linked list
        int count=0;
        ListNode p= head;
        while (p != null){
            p= p.next;
            count++;
        }
        //If n==count means head of the LL is required to remove
        if (count==n)
            return head.next;

        p= head;
        //Will traverse till n-1 nodes then we will remove the node at n (from last)
        while (count-1>n){
            p= p.next;
            count--;
        }
        if (p.next!=null)
            p.next= p.next.next;
        return head;

        //Optimized Code
        // ListNode front= head;
        // ListNode back= head;
        // int x= n;
        // while (x>0){
        //     front= front.next;
        //     x--;
        // }
        // if (front==null){
        //     return head.next;
        // }
        // while (front.next!=null){
        //     front= front.next;
        //     back= back.next;
        // }
        // back.next= back.next.next;
        // return head;
    }
}