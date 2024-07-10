import java.util.*;

class Solution {
    
    class Node {
        int n;
        Node prev;
        Node next;
        
        Node(int n, Node prev, Node next) {
            this.n=n;
            this.prev=prev;
            this.next=next;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        char[] result = new char[n];
        Arrays.fill(result,'O');
        Stack<Node> removeRow = new Stack<>();

        Node cur = new Node(0, null, null);
        Node tmp = cur;

        for (int i = 1; i < n; i++) {
            Node node = new Node(i, tmp, null);
            tmp.next = node;
            tmp = node;
        }

        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        for (String s : cmd) {
            StringTokenizer st = new StringTokenizer(s);
            String c = st.nextToken();

            switch (c) {
                case "D":
                    cur = move(cur, Integer.parseInt(st.nextToken()));
                    break;
                case "U":
                    cur = move(cur, -Integer.parseInt(st.nextToken()));
                    break;
                case "C":
                    Node removeNode = cur;
                    result[removeNode.n]='X';
                    
                    Node prev = cur.prev;
                    Node next = cur.next;
                    if(prev!=null) prev.next = next;
                    if(next==null){
                        cur=prev;
                    }else{
                        cur=next;
                        next.prev=prev;
                    }
                    
                    removeRow.add(removeNode);
                    break;
                case "Z":
                    Node node = removeRow.pop();
                    result[node.n]='O';
                    
                    prev = node.prev;
                    next = node.next;
                    if(prev!=null){
                        prev.next = node;
                    }
                    
                    if(next!=null){
                        next.prev=node;
                    }
                    break;
            }
        }

        return String.valueOf(result);
    }
    
    Node move(Node cur, int dist){
        if(dist>0){
            for(int i=0;i<dist;i++){
                cur=cur.next;
            }
        }else{
            for(int i=0;i<(-dist);i++){
                cur=cur.prev;
            }
        }
        return cur;
    }
}