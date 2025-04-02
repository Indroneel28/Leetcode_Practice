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
    //METHOD 3:- USING INORDER TRAVERSAL and Instance Variables
    public int count, k, answer;
    public int kthSmallest(TreeNode root, int k) {
        this.count= 0;
        this.k= k;
        this.answer= -1;
        traverse(root);
        return answer;
    }
    private void traverse(TreeNode root){
        if (root==null)
            return;
        traverse(root.left);
        count++;
        if (count==k)
            answer= root.val;
        traverse(root.right);
    }
    //TC is O(k) and SC is nearly O(n)
}