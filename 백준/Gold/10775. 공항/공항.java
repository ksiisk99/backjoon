import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int G, P;
    private static int[] parent;

    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        parent[u] = v;
    }

    static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent=new int[G+1];

        for(int i=1;i<=G;i++)parent[i]=i;

        int result=0;
        for(int i=1;i<=P;i++){
            int gate = find(Integer.parseInt(br.readLine()));

            if(gate == 0){
                break;
            }
            result++;
            union(gate,gate-1);
        }

        System.out.println(result);

    }


}