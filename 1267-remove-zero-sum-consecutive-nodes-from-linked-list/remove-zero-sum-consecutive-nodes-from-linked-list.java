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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> hashMap= new HashMap<>();
        ListNode newRoot= new ListNode(0);
        newRoot.next= head;
        int sum= 0;
        for (ListNode p= newRoot; p!=null; p= p.next){
            sum+=p.val;
            hashMap.put(sum,p);
        }

        sum=0;
        for (ListNode p= newRoot; p!=null; p=p.next){
            sum+=p.val;
            p.next= hashMap.get(sum).next;
        }
        return newRoot.next;
    }
}