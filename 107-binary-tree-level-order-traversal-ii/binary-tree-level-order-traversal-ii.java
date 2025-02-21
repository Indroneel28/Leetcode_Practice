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
    //METHOD 1:- USING BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer= new ArrayList<>();
        
        //Edge case
        if (root==null)
            return answer;

        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> list= new ArrayList<>();
            for (int i=1; i<=size; i++){
                TreeNode node= queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            answer.add(0,new ArrayList<>(list));
        }

        return answer;
    }
    //TC is O(n) and SC is O(2n)
}