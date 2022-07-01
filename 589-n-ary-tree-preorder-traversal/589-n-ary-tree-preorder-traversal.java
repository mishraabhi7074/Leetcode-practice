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

//do it again
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        binary(root, list);
        
        return list;
    }
    
    void binary(Node node, List<Integer> list){
        if(node == null)
            return;
        list.add(node.val);
        for(int i = 0; i < node.children.size(); i++){
            binary(node.children.get(i), list);
        }
    }
}