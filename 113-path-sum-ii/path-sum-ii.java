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
    //METHOD 1:- USING DFS
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        
        if (root==null)
            return answer;
        
        dfs(answer,list,targetSum,root);
        return answer;
    }
    //Helper Method
    private void dfs(List<List<Integer>> answer, List<Integer> list, int targetSum, TreeNode node){
        //Base case
        list.add(node.val);
        if (targetSum==node.val && node.left==null && node.right==null){
            answer.add(new ArrayList<>(list));
        }
        
        if (node.left!=null){
            dfs(answer,list,targetSum-node.val,node.left);
        }
        if (node.right!=null){
            dfs(answer,list,targetSum-node.val,node.right);
        }
        list.remove(list.size()-1);
    }
    //TC is O(n) and SC is O(2n)
}