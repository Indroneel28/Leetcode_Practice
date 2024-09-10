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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head==null || head.next==null)
            return head;
        for (ListNode i=head; i.next!=null; i= i.next.next){
            ListNode future= i.next;
            ListNode newNode= new ListNode(findGCD(i.val,future.val));
            newNode.next= i.next;
            i.next= newNode;
        }
        return head;
        //TC is O(n) and SC is O(n-1)
    }

    //Finding GCD using Euclidean method
    private int findGCD(int a, int b){
        if (a==1 || b==1)
            return 1;
        while (b!=0){
            int rem= a%b;
            a= b;
            b= rem;
        }
        return a;
    }
}