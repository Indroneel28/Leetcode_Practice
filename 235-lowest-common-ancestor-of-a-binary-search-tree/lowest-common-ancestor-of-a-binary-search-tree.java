/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //METHOD 2:- LCA of BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }
    //TC is O(logn) and SC is O(logn)
}