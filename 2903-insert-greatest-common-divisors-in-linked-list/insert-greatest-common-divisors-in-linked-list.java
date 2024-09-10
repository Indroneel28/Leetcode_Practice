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

    private int findGCD(int a, int b){
        int gcd= 1;
        for (int i=1; i<=a; i++){
            if (a%i==0 && b%i==0)
                gcd= i;
        }
        return gcd;
    }
}