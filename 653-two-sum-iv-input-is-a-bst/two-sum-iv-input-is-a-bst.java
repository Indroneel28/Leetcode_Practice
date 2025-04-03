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
    //METHOD 1:- Traverse and HashSet
    public boolean findTarget(TreeNode root, int k) {
        return traverse(root,k,new HashSet<>());
    }
    private boolean traverse(TreeNode node, int k, HashSet<Integer> set){
        if (node==null)
            return false;
        if (set.contains(k-node.val))
            return true;
        set.add(node.val);
        return traverse(node.left,k,set) || traverse(node.right,k,set);
    }
    //TC is O(n) and SC is O(2n)
}