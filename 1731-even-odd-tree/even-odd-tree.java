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
    public boolean isEvenOddTree(TreeNode root) {
        //USING BFS IN GRAPH
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int level= 0;
        while (!queue.isEmpty()){
            int size= queue.size(), store;
            boolean levelEven= level%2==0;
            if (levelEven)
                store= Integer.MIN_VALUE;
            else
                store= Integer.MAX_VALUE;
            ArrayList<TreeNode> arrayList= new ArrayList<>();
            for (int i=1; i<=size; i++){
                TreeNode node= queue.remove();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (levelEven){ //Even level must contain odd integers in strictly increasing order
                    if (node.val%2==0 || store>=node.val){
                        return false;
                    }
                    else if (node.val>store){
                        store= node.val;
                    }
                }
                else { //Odd level must contain even integers in strictly decreasing order
                    if (node.val%2==1 || store<=node.val){
                        return false;
                    }
                    else if (node.val<store){
                        store= node.val;
                    }
                }
            }
            level++;
        }
        return true;
    }
}