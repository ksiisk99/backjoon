import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int[] parent;

    static int find(int n){
        if(n==parent[n])return n;
        return parent[n]=find(parent[n]);
    }

    static void union(int a,int b){
        if(a>b){
            parent[b]=a;
            return;
        }
        parent[a]=b;
    }

    static class Node implements Comparable<Node>{
        int a,b,cost;

        @Override
        public int compareTo(Node o) {
            return cost-o.cost;
        }

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=1;i<=N;i++)parent[i]=i;

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Node(a,b,c));
        }

        int result=0;
        int lastEdgeCost=0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int a=find(node.a);
            int b=find(node.b);
            if(a!=b){
                result+=node.cost;
                union(a,b);
                lastEdgeCost=node.cost;
            }
        }

        System.out.println(result-lastEdgeCost);
    }
}