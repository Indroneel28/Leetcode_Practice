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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] answer= {-1,-1};

        //Given, The number of nodes in the list is in the range [2, 105]. {in the constraints}
        ArrayList<Integer> list= new ArrayList<>();

        ListNode p= head.next;
        ListNode previous= head;
        int index= 2;
        while (p.next!=null){
            if (p.val>previous.val && p.val>p.next.val)
                list.add(index);
            else if (p.val<previous.val && p.val<p.next.val)
                list.add(index);
            index++;
            previous= p;
            p= p.next;
        }

        if (list.size()<2)
            return answer;

        //Storing the maximum distance
        int max= list.get(list.size()-1)-list.get(0); //last index- first index
        answer[1]= max;
        
        //Storing the minimum distance
        int min= Integer.MAX_VALUE;
        for (int i=0; i<list.size()-1; i++){
            if (list.get(i+1)-list.get(i)<min)
                min= list.get(i+1)-list.get(i);
        }
        answer[0]= min;
        
        return answer;
    }
}