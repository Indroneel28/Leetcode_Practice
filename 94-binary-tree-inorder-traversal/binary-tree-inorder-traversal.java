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
    //InOrder Traversal means (Left Subtree -> Root Node --> Right Subtree)

    //METHOD 1:- USING RECURSION
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        inOrder(root,list);
        return list;
    }
    private void inOrder(TreeNode node, List<Integer> list){
        if (node!=null){
            inOrder(node.left,list);
            list.add(node.val);
            inOrder(node.right,list);
        }
    }
    //TC is O(n) and SC is O(n)
}