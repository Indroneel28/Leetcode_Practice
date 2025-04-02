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
    //METHOD 1:- USING STACK
    public int count= 0;
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            pq.offer(node.val);
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
        }
        int c= 0, ans= -1;
        while (c<k) {
            ans = pq.poll();
            c++;
        }
        return ans;
    }
    //TC is O(2logn) and SC is O(logn)
}