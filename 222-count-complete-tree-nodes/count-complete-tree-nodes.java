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
    //METHOD 1:- USING DFS TRAVERSAL
    public int count;
    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
    //TC is O(n) and SC is O(n)
}