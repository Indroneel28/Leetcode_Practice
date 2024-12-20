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
    //BFS METHOD
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        boolean odd= true;
        while (!queue.isEmpty()){
            ArrayList<TreeNode> list= new ArrayList<>();

            while (!queue.isEmpty()){
                TreeNode node= queue.poll();
                if(node.left!=null)
                    list.add(node.left);
                if(node.right!=null)
                    list.add(node.right);
            }

            if (odd && !list.isEmpty()){
                for (int i=0; i<list.size()/2; i++){
                    TreeNode node1= list.get(i);
                    TreeNode node2= list.get(list.size()-1-i);
                    
                        int temp = node1.val;
                        node1.val = node2.val;
                        node2.val = temp;
                    
                }
            }
            queue.addAll(list);
            list= new ArrayList<>();
            odd= !odd; //For next iteration
        }
        return root;
    }
}