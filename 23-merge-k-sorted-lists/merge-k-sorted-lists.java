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
    public ListNode mergeKLists(ListNode[] lists) {
        //METHOD 1:- USING ARRAYLIST AND SORTING
        /*
        ArrayList<Integer> arrayList= new ArrayList<>();
        for (ListNode list: lists){
            ListNode p= list;
            while (p!=null){
                arrayList.add(p.val);
                p= p.next;
            }
        }

        arrayList.sort(null);
        ListNode newHead= new ListNode(-1);
        ListNode p= newHead;
        for (int element: arrayList){
            ListNode node= new ListNode(element);
            p.next= node;
            p= node;
        }
        return newHead.next;
         */

        //METHOD 2:- USING PRIORITY QUEUE
        PriorityQueue<ListNode> priorityQueue= new PriorityQueue<>(Comparator.comparingInt((ListNode node)->node.val));
        for (ListNode list: lists){
            ListNode p= list;
            while (p!=null){
                priorityQueue.add(p);
                p= p.next;
            }
        }

        ListNode newHead= new ListNode(-1);
        ListNode p= newHead;
        while(!priorityQueue.isEmpty()){
            ListNode node= new ListNode(priorityQueue.poll().val);
            p.next= node;
            p= node;
        }
        return newHead.next;
    }
}