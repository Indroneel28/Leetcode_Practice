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
    public List<Integer> postorder(Node root) {
        List<Integer> answer= new ArrayList<>();
        traverse(root,answer);
        return answer;
    }
    
    private void traverse(Node node, List<Integer> answer){
        if (node!=null){
            for (Node child: node.children){
                traverse(child,answer);
            }
            answer.add(node.val);
        }
    }
}