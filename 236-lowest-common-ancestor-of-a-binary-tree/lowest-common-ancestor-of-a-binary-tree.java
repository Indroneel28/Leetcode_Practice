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
    //METHOD 1:- BRUTE FORCE BFS
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        TreeNode ans= null;
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            if (check(node,p) && check(node,q))
                ans= node;
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
        }
        return ans;
    }
    private boolean check(TreeNode root, TreeNode p){
        if (root==null)
            return false;
        if (root.val==p.val)
            return true;
        return check(root.left,p) || check(root.right,p);
    }
    //TC is O(n^2) and SC is O(n)
}