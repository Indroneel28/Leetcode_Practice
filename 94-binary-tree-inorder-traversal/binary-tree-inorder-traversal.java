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
    //METHOD 3:- Using Morris Traversal Algorithm
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer= new ArrayList<>();
        TreeNode curr= root;
        while (curr!=null){
            if (curr.left==null){
                answer.add(curr.val);
                curr= curr.right;
            }
            else{
                TreeNode prev= curr.left;
                while (prev.right!=null && prev.right!=curr){
                    prev= prev.right;
                }
                if (prev.right==null){
                    prev.right= curr;
                    curr= curr.left;
                }
                else {
                    prev.right= null;
                    answer.add(curr.val);
                    curr= curr.right;
                }
            }
        }
        return answer;
    }
    //TC is O(n) and SC is O(1)
}