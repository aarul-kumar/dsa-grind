/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> hm = new HashMap<>();

        hm.put(node,new Node(node.val, new ArrayList<>()));
        q.add(node);

        while(!q.isEmpty()){
            Node curr=q.remove();
            
            for(int i=0; i<curr.neighbors.size(); i++){
                Node neigh = curr.neighbors.get(i);

                if(!hm.containsKey(neigh)){
                    hm.put(neigh,new Node(neigh.val, new ArrayList<>()));
                    q.add(neigh);
                }

                hm.get(curr).neighbors.add(hm.get(neigh));
            }
        }

        return hm.get(node);
    }
}