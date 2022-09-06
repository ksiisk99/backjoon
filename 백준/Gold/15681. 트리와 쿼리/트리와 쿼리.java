import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjust;
    static boolean[] visit;
    static int[] parent;
    
    static void makeParent(int childNode){
        visit[childNode]=true;
        boolean check=true;

        for(int next:adjust[childNode]){
            if(!visit[next]) {
                makeParent(next);
                parent[childNode]+=parent[next];
                check=false;
            }
        }
        if(check)parent[childNode]=1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N,R,Q;
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());

        adjust=new ArrayList[N+1];
        visit=new boolean[N+1];
        parent=new int[N+1];
        
        for(int i=1;i<=N;i++){
            parent[i]=1;
            adjust[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int U=Integer.parseInt(st.nextToken());
            int V=Integer.parseInt(st.nextToken());
            adjust[U].add(V);
            adjust[V].add(U);
        }
        makeParent(R);
        for(int i=0;i<Q;i++){
            sb.append(parent[Integer.parseInt(br.readLine())]+"\n");
        }
        System.out.print(sb.toString());
    }
}