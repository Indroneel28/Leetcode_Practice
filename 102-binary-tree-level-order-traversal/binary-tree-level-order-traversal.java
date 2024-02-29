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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new LinkedList<>();
        List<List<Integer>> answer= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        List<Integer> current= new ArrayList<>();
        ArrayList<TreeNode> storeChildren= new ArrayList<>(); //store
        while (!queue.isEmpty()){
            TreeNode node= queue.remove();
            current.add(node.val);
            if (node.left!=null){
                storeChildren.add(node.left);
            }
            if (node.right!=null){
                storeChildren.add(node.right);
            }
            if (queue.isEmpty()){
                answer.add(current);
                current= new ArrayList<>();
                queue.addAll(storeChildren);
                storeChildren= new ArrayList<>();
            }
        }
        return answer;
    }
}