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
    //METHOD 1:- RECURSION METHOD
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null)
            return null;
        else if (root.val==val)
            return root;
        else if (root.val<val)
            return searchBST(root.right,val);
        else 
            return searchBST(root.left,val);
    }
    //TC is O(logn) and SC is O(logn) coz of Stack space due to Recursion
}