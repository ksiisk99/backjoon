

import java.io.*;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] edges=new ArrayList[V+1];
			Queue<Integer>queue=new LinkedList<Integer>();
			int[] visit=new int[V+1];
		
			for(int i=0;i<=V;i++) {
				edges[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(br.readLine());
				int n1=Integer.parseInt(st.nextToken());
				int n2=Integer.parseInt(st.nextToken());
				edges[n1].add(n2);
				edges[n2].add(n1);
			}
			
			boolean check=false;
			for(int i=1;i<=V;i++) {
				if(visit[i]==0) {
					queue.add(i);
					visit[i]=1;
				}
				while(!queue.isEmpty()) {
					int cur=queue.poll();
					for(int next:edges[cur]) {
						if(visit[next]==0) {
							queue.add(next);
						}
						if(visit[next]==visit[cur]) {
							sb.append("NO\n");
							queue.clear();
							check=true;
							break;
						}
						
						if(visit[cur]==1 && visit[next]==0) {
							visit[next]=2;
						}else if(visit[cur]==2 && visit[next]==0) {
							visit[next]=1;
						}
						
					}
				}
				if(check)break;
			}
			if(!check)sb.append("YES\n");
			
		}
		System.out.print(sb.toString());
		
		
	}

}
