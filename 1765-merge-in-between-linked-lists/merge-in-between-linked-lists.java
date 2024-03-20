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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeBeforeA=list1, nodeAfterB=list1;
        ListNode p= list1; int c=0;
        while (p!=null){
            if(c==a-1)
                nodeBeforeA= p;
            if (c==b+1) {
                nodeAfterB = p;
                break;
            }
            p= p.next;
            c++;
        }
        nodeBeforeA.next= list2;
        ListNode tailOfList2= list2;
        while (tailOfList2.next!=null)
            tailOfList2= tailOfList2.next;
        tailOfList2.next= nodeAfterB;
        return list1;
    }
}