/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //METHOD 1:- MAKE THE TREE LIKE A GRAPH
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //Step 1:- Mark parents in a map
        Map<TreeNode,TreeNode> parents= new HashMap<>();
        markParents(root,parents);

        //Step 2:- Traverse from target node to neighbour nodes till k
        Map<TreeNode,Boolean> visited= new HashMap<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int curr_level= 0;

        while (!queue.isEmpty()){
            if (curr_level==k)
                break;
            curr_level++;
            int n= queue.size();
            for (int i=0; i<n; i++){
                TreeNode node= queue.poll();
                if (node.left!=null && !visited.containsKey(node.left)){
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if (node.right!=null && !visited.containsKey(node.right)){
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }
                if (parents.containsKey(node) && !visited.containsKey(parents.get(node))){
                    queue.offer(parents.get(node));
                    visited.put(parents.get(node),true);
                }
            }
        }
        List<Integer> ans= new ArrayList<>();
        while (!queue.isEmpty())
            ans.add(queue.poll().val);
        return ans;
    }

    private void markParents(TreeNode root, Map<TreeNode,TreeNode> map){
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            if (node.left!=null){
                map.put(node.left,node);
                queue.offer(node.left);
            }
            if (node.right!=null){
                map.put(node.right,node);
                queue.offer(node.right);
            }
        }
    }

    //TC is O(2n) and SC is O(3n)
}