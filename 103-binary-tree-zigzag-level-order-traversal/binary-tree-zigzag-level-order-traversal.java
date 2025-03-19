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
    //METHOD 1:- BFS TRAVERSAL
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer= new ArrayList<>();
        if (root==null)
            return answer;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        boolean insertLeftToRight= false;
        while (!queue.isEmpty()){
            int n= queue.size();
            insertLeftToRight= !insertLeftToRight;
            List<Integer> list= new ArrayList<>();
            for (int i=0; i<n; i++){
                TreeNode node= queue.poll();
                if (insertLeftToRight)
                    list.add(node.val);
                else
                    list.add(0,node.val);
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
            answer.add(new ArrayList<>(list));
        }
        return answer;
    }
    //TC is O(n) and SC is O(n)
}