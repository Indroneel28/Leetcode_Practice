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
    //METHOD 1:- USing DFS with left first then right
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list= new ArrayList<>();
        dfs(root,new StringBuilder(),list);
        return list;
    }
    private void dfs(TreeNode root, StringBuilder sb, List<String> list){
        if (root.left==null && root.right==null){
            int s= sb.length();
            sb.append(root.val);
            list.add(sb.toString());
            if (s!=0)
                sb.delete(s,sb.length());
            return;
        }
        int k= sb.length();
        sb.append(root.val);
        sb.append("->");
        if (root.left!=null)
            dfs(root.left,sb,list);
        if (root.right!=null)
            dfs(root.right,sb,list);
        if (k!=0)
            sb.delete(k,sb.length());
    }
    //TC is O(n) and SC is O(2n)
}