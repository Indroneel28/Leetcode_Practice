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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if (root==null)
            return list;
        Stack<TreeNode> stack= new Stack<>();
        TreeNode curr= root;

        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr= curr.left;
            }
            curr= stack.pop();
            list.add(curr.val);
            curr= curr.right;
        }
        return list;
    }
    //TC is O(n) and SC is O(n)
}