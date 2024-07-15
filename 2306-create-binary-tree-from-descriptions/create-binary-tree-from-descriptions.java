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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> store= new HashSet<>();
        Map<Integer,TreeNode> map= new HashMap<>();

        for (int[] description: descriptions){
            int parent= description[0];
            int child= description[1];
            int direction= description[2];

            TreeNode parentNode= map.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode= map.getOrDefault(child, new TreeNode(child));
            
            if (direction==1)
                parentNode.left= childNode;
            else
                parentNode.right= childNode;

            map.put(parent,parentNode);
            map.put(child,childNode);
            store.add(child); //Add all the children
        }

        TreeNode root= new TreeNode(-1);
        for (int[] description : descriptions){
            int parent= description[0];
            if (!store.contains(parent)) //If parent is not there in children store means it's root
                root= map.get(parent);
        }

        // Root is left which is not child of anyone left in store
        return root;
    }
}