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
    //METHOD 2:- OPTIMIZED DFS WITHOUT TREEMAP (BEST METHOD)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        traverse(root,0,ans);
        return ans;
    }
    private void traverse(TreeNode node, int row, List<Integer> list){
        if (node==null)
            return;
        if (row>=list.size())
            list.add(node.val);
        traverse(node.right,row+1,list);
        traverse(node.left,row+1,list);
    }
    //TC is O(n) and SC is O(n)
}