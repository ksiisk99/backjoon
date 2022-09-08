import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjust;
    static int[] cost;
    static int[] chk;
    static int[][] table;
    static ArrayList<Integer>[] tree;
    static List<Integer>answer;

    static void dfs(int now,int prev){
        for(int next:adjust[now]){
            if(next != prev){
                tree[now].add(next);
                dfs(next,now);
            }
        }
    }

    static int dp(int now, int include){
        if(table[now][include]>0)return table[now][include];
        int ans=0;
        if(include==1){
            for(int next:tree[now]){
                ans+=dp(next,0);
            }
            return table[now][include]=ans+cost[now];
        }else{
            for(int next:tree[now]){
                int t1=dp(next,0);
                int t2=dp(next,1);
                if(t1<t2){
                    chk[next]=1;
                    ans+=t2;
                }else{
                    chk[next]=0;
                    ans+=t1;
                }
            }
            return table[now][include]=ans;
        }
    }

    static void track(int now,int include){
        if(include==1){
            answer.add(now);
            for(int next:tree[now]){
                track(next,0);
            }
        }else{
            for(int next:tree[now]){
                track(next,chk[next]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N;
        N=Integer.parseInt(br.readLine());

        adjust=new ArrayList[N+1];
        tree=new ArrayList[N+1];
        table=new int[N+1][2];
        chk=new int[N+1];
        cost=new int[N+1];
        answer=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            cost[i]=Integer.parseInt(st.nextToken());
            adjust[i]=new ArrayList<Integer>();
            tree[i]=new ArrayList<Integer>();
            table[i][0]=table[i][1]=-1;
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int U=Integer.parseInt(st.nextToken());
            int V=Integer.parseInt(st.nextToken());
            adjust[U].add(V);
            adjust[V].add(U);
        }
        dfs(1,1);

        int t1=dp(1,0);
        int t2=dp(1,1);
        if(t1<t2)chk[1]=1;
        else chk[1]=0;
        System.out.println(Math.max(t1,t2));

        track(1,chk[1]);
        Collections.sort(answer);
        answer.stream()
                .forEach(i-> sb.append(i+" "));
        System.out.println(sb.toString());
    }
}
