import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.sort;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, K;
    private static int[] cards, parent;

    private static int upperBound(int card) {
        int left = 0;
        int right = M;

        while (left < right) {
            int mid = (left + right) / 2;

            if (cards[mid] <= card) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private static int find(int a) {
        if (parent[a]==-1) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        if(b==M)return;
        parent[a]=b;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cards = new int[M];
        parent = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(parent,-1);

        sort(cards);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int idx = find(upperBound(Integer.parseInt(st.nextToken())));
            sb.append(cards[idx]);
            sb.append("\n");
            union(idx, idx + 1);
        }
        System.out.print(sb.toString());
    }
}