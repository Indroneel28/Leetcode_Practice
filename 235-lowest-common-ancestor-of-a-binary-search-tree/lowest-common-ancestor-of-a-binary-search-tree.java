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
    //METHOD 3:- ITERATIVE VERSION OF (LCA OF BST)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node= root;
        while (node!=null){
            if (p.val<node.val && q.val<node.val)
                node= node.left;
            else if (p.val>node.val && q.val> node.val)
                node= node.right;
            else 
                return node;
        }
        return null; //dummy statement
    }
    //TC is O(logn) and SC is O(1)
}