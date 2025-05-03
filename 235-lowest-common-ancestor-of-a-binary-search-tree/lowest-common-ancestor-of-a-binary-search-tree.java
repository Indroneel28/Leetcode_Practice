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
    //METHOD 1:- LCA of Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root,p,q);
    }
    private TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)
            return null;
        TreeNode left= traverse(root.left,p,q);
        TreeNode right= traverse(root.right,p,q);
        if (left!=null && right!=null)
            return root;
        else if (root==p || root==q)
            return root;
        else if (left!=null)
            return left;
        else if (right!=null)
            return right;
        else 
            return null;
    }
    //TC is O(n) and SC is O(n)
}