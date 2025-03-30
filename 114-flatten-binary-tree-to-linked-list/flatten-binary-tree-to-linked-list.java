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
        TreeNode ans= new TreeNode(-1);
        TreeNode p= ans;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node= stack.pop();
            p.right= new TreeNode(node.val);
            p= p.right;
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
        root.left= root.right= null;
        root.right= ans.right.right;
    }
}