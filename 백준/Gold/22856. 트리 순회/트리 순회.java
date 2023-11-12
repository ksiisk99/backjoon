import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static Node[] edges;
    private static int endNode;
    private static boolean check = true;
    private static int answer;

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static void inOrder(int node) {
        int leftNode = edges[node].left;
        int rightNode = edges[node].right;

        if(leftNode!=-1) {
            inOrder(leftNode);
        }

        endNode = node;
        if(rightNode!=-1) {
            inOrder(rightNode);
        }
    }

    private static void inOrder2(int node) {
        int leftNode = edges[node].left;
        int rightNode = edges[node].right;

        if(leftNode!=-1) {
            answer++;
            inOrder2(leftNode);
            if(check) answer++;
        }

        if(rightNode!=-1) {
            answer++;
            inOrder2(rightNode);
            if(check)answer++;
        }

        if(node == endNode) check = false;
    }


    public static void main(String[] args) throws IOException {
        input();
        inOrder(1);
        inOrder2(1);

        System.out.print(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        edges = new Node[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            edges[parent]= new Node(left, right);
        }
    }

}
