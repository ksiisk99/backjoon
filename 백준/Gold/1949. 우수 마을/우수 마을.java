import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjust;
    static int[][] dp;
    static ArrayList<Integer>[] tree;
    static int[] cost;

    static void createTree(int now,int prev){
        for(int next:adjust[now]){
            if(next != prev){
                tree[now].add(next);
                createTree(next,now);
            }
        }
    }

    static int recursion(int now, int include){
        if(dp[now][include]>0)return dp[now][include];
        int ans=0;
        if(include==1){
            ans=cost[now];
            for(int next:tree[now]) {
                ans += recursion(next,0);
            }
        }else{
            for(int next:tree[now]){
                int t1=recursion(next,0);
                int t2=recursion(next,1);
                ans+=Math.max(t1,t2);
            }
        }
        return dp[now][include]=ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        adjust=new ArrayList[N+1];
        tree=new ArrayList[N+1];
        dp=new int[N+1][2];
        cost=new int[N+1];

        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            adjust[i]=new ArrayList<Integer>();
            tree[i]=new ArrayList<Integer>();
            cost[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int U=Integer.parseInt(st.nextToken());
            int V=Integer.parseInt(st.nextToken());
            adjust[U].add(V);
            adjust[V].add(U);
        }

        createTree(1,1);
        int t1=recursion(1,0);
        int t2=recursion(1,1);
        System.out.println(Math.max(t1,t2));
    }
}
