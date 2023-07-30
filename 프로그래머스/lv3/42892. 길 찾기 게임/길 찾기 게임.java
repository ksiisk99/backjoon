import java.util.*;
import java.util.stream.*;

class Solution {
    class Node implements Comparable<Node>{
        int n,x,y;
        Node left, right;
        
        Node(int n, int x,int y) {
            this.n=n;
            this.x=x;
            this.y=y;
        }
        
        @Override
        public int compareTo(Node o){
            if(o.x==x){
                return y-o.y;
            }
            return o.x-x;
        }
    }
    
    int idx = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        List<Node> tree = new ArrayList<>();
        idx = 1;
        for(int[] node: nodeinfo) {
            Node n = new Node(idx++, node[1], node[0]);
            tree.add(n);
        }
        Collections.sort(tree);
        
        Node root = tree.get(0);
        for(int i=1;i<tree.size();i++){
            insert(root, tree.get(i));
        }
        
        answer = new int[2][idx-1];
        idx=0;
        preOrder(root, answer[0]);
        idx=0;
        postOrder(root,answer[1]);
        return answer;
    }
    
    void postOrder(Node root, int[] answer){
        if(root.left!=null){
            postOrder(root.left, answer);
        }
        
        if(root.right!=null){
            postOrder(root.right, answer);
        }
        answer[idx++]=root.n;
    }
    
    void preOrder(Node root, int[] answer) {
        answer[idx++]= root.n;
        if(root.left!=null){
            preOrder(root.left, answer);
        }
        
        if(root.right!=null){
            preOrder(root.right, answer);
        }
    }
    
    void insert(Node parent, Node child) {
        if(parent.y>child.y){
            if(parent.left == null){
                parent.left=child;
            }else{
                insert(parent.left, child);
            }
        } else {
            if(parent.right==null) {
                parent.right=child;
            }else{
                insert(parent.right,child);
            }
        }       
    }
}