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
    //BREADTH FIRST SEARCH
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        boolean odd= true;
        while (!queue.isEmpty()){
            ArrayList<TreeNode> list= new ArrayList<>();
            int size= queue.size();
            for (int i=0; i<size; i++){
                TreeNode node= queue.poll();
                if (node.left!=null)
                    list.add(node.left);
                if (node.right!=null)
                    list.add(node.right);
            }
            if(odd){
                int i=0, j=list.size()-1;
                while (i<j){
                    TreeNode node1= list.get(i), node2= list.get(j);
                    int val= node1.val;
                    node1.val= node2.val;
                    node2.val= val;
                    i++; j--;
                }
            }
            queue.addAll(list);
            odd= !odd;
        }
        return root;
    }
    //TC is O(n) and SC is O(n)
}