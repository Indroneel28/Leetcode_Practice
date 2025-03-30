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
    //METHOD 1:- Iterative Pre-Order Traversal
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);

        TreeNode newNodes= new TreeNode(-1);
        TreeNode p= newNodes;
        while (!stack.isEmpty()){
            TreeNode node= stack.pop();
            p.left= null;
            p.right= node;
            p= p.right;
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        root= newNodes.right;
    }
    //TC is O(n) and SC is O(n)
}