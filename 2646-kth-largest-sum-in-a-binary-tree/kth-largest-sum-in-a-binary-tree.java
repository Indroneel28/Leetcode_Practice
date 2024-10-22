/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        //USING DATA STRUCTURES

        //To store the max
        PriorityQueue<Long> sums= new PriorityQueue<>(Collections.reverseOrder());

        Queue<TreeNode> queue= new ArrayDeque<>();
        Queue<TreeNode> queue2= new ArrayDeque<>();
        queue.add(root);
        long sum= 0;

        while (!queue.isEmpty()){
            TreeNode node= queue.remove();
            if (node.left!=null)
                queue2.add(node.left);
            if (node.right!=null)
                queue2.add(node.right);
            sum+=node.val;
            if (queue.isEmpty()){
                sums.add(sum); //Add the sum of one level
                sum= 0; //Again sum=0 for next level
                queue.addAll(queue2);
                queue2= new ArrayDeque<>(); //Empty queue 2 for next level
            }
        }


        int i= 1;
        while (!sums.isEmpty() && i<k) { //runs k-1 times
            sums.remove();
            i++;
        }

        if (!sums.isEmpty())
            return sums.peek();
        else
            return -1;
        //TC is O(n+k) and SC is O(3n)
    }
}