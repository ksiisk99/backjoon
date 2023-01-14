import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());

        int N, M;
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int[] degree=new int[N+1];
        List<Integer>list[] = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            list[a].add(b);
            degree[b]++;
        }

        Queue<Integer> queue =new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int n=queue.poll();
            sb.append(n);
            sb.append(" ");

            for(int i:list[n]){
                degree[i]--;
                if(degree[i]==0){
                    queue.add(i);
                }
            }
        }
        System.out.println(sb.toString());
    }


}