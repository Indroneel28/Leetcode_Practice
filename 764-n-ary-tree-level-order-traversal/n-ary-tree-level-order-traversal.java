/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        //BFS METHOD

        //If there are 0 nodes
        if (root==null)
            return new ArrayList<>();

        //Add root node inside the queue
        Queue<Node> queue= new ArrayDeque<>();
        queue.add(root);

        //To store answer
        List<List<Integer>> answer= new ArrayList<>();
        
        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> list= new ArrayList<>();
            for (int i=0; i<size; i++){
                Node node= queue.poll();
                list.add(node.val);
                for (Node child: node.children){
                    queue.offer(child);
                }
            }
            answer.add(new ArrayList<>(list));
        }
        
        return answer;
    }
}