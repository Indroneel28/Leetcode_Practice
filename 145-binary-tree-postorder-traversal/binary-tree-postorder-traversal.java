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
    //METHOD 2:- ITERATIVE SOLUTION using Stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if (root==null)
            return list;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node= stack.pop();
            list.add(0,node.val);
            if (node.left!=null)
                stack.add(node.left);
            if (node.right!=null)
                stack.add(node.right);
        }
        return list;
    }
    //TC is O(n) and SC is O(n)
}