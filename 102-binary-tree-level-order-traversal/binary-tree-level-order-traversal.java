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
        //MY METHOD
        /*
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
         */
        //TIME COMPLEXITY:- O(N) because all nodes are visited once

        //METHOD 2:-
        if (root==null)
            return new LinkedList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> answer= new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int n= queue.size();
            List<Integer> list= new ArrayList<>();
            for (int i=1; i<=n; i++){ //run n times
                TreeNode node= queue.remove();
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            System.out.println(list);
            answer.add(list);
        }
        return answer;
    }
}