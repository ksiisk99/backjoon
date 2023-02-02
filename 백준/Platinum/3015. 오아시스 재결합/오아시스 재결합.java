import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;

    static class Node {
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Node> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            boolean isEqualsHeight = false;
            int cnt = 1;
            int idx = 0;
            while (!stack.isEmpty()) {
                if (arr[stack.peek().idx] > arr[i]) {
                    if(tmp!=0)answer++;
                    break;
                }

                Node node = stack.pop();
                answer += node.cnt;
                if (arr[i] == arr[node.idx]) {
                    idx = node.idx;
                    if(isEqualsHeight){
                        cnt++;
                    }else{
                        cnt=node.cnt;
                    }
                    isEqualsHeight = true;
                    cnt++;
                }
                if (tmp <= arr[node.idx]) {
                    tmp = arr[node.idx];
                } else {
                    break;
                }
            }
            if (isEqualsHeight) {
                stack.push(new Node(idx, cnt));
                continue;
            }
            if (i!=0 && tmp == 0) {
                answer++;
            }
            stack.push(new Node(i, 1));
        }
        System.out.print(answer);
    }


}