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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        //Declaring Matrix
        int[][] matrix= new int[m][n];

        //Filling all element with -1
        for (int[] rows: matrix){
            Arrays.fill(rows,-1);
        }

        //Note:- The number of nodes in the list is in the range [1, m * n]
        ListNode p= head;
        int left= 0, right= n-1, top= 0, bottom= m-1;

        while (p!=null){
            //Move Rightwards
            for (int i=left; i<=right && p!=null; i++){
                matrix[top][i]= p.val;
                p= p.next;
            }
            top++;

            //Move Downwards
            for (int i=top; i<=bottom && p!=null; i++){
                matrix[i][right]= p.val;
                p= p.next;
            }
            right--;

            //Move leftwards
            for (int i=right; i>=left && p!=null; i--){
                matrix[bottom][i]= p.val;
                p= p.next;
            }
            bottom--;

            //Move upwards
            for (int i=bottom; i>=top && p!=null; i--){
                matrix[i][left]= p.val;
                p= p.next;
            }
            left++;
        }
        
        return matrix;
        //TC is O(m*n) and SC is O(m*n)
    }
}