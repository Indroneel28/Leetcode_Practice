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
    //METHOD 1:- USING DFS, TREEMAP AND PRIORITY QUEUE
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // cols -- rows -- value
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        traverse(root,0,0,map);

        List<List<Integer>> answer= new ArrayList<>();
        for (Integer cols: map.keySet()){
            List<Integer> list= new ArrayList<>();
            TreeMap<Integer,PriorityQueue<Integer>> colValues= map.get(cols);
            for (Integer rows: colValues.keySet()){
                PriorityQueue<Integer> nodes= map.get(cols).get(rows);
                while (!nodes.isEmpty()){
                    list.add(nodes.poll());
                }
            }
            answer.add(new ArrayList<>(list));
        }
        return answer;
    }
    private void traverse(TreeNode node, int col, int row, TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map){
        if (node==null)
            return;
        map.putIfAbsent(col,new TreeMap<>());
        map.get(col).putIfAbsent(row,new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);
        traverse(node.left,col-1,row+1,map);
        traverse(node.right,col+1,row+1,map);
    }
    //TC is O(2n) and SC is O(n)
}