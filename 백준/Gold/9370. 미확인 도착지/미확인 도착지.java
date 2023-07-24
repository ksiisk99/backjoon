

import java.io.*;
import java.util.*;

public class Main {
	static int[] visit;
	static int n;
	static ArrayList[] adj;
	static class Edge implements Comparable<Edge>{
		int node,cost;
		
		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}		
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tz=0;tz<T;tz++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken()); //정점 수
			int m=Integer.parseInt(st.nextToken()); //간선 수
			int t=Integer.parseInt(st.nextToken()); //목적지 수
			ArrayList<Integer> ans=new ArrayList<Integer>();
			adj=new ArrayList[n+1];
			visit=new int[n+1];
			for(int i=1;i<=n;i++) {
				adj[i]=new ArrayList<Edge>();
			}
			
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()); //예술가들의 출발지
			int g=Integer.parseInt(st.nextToken()); //g와 h 교차로 사이에 도로를 지나감
			int h=Integer.parseInt(st.nextToken());
			
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());

				adj[a].add(new Edge(b,c));
				adj[b].add(new Edge(a,c));
			}
			int[] candidate=new int[t]; //예술가들의 목적지 후보
			for(int i=0;i<t;i++) {
				candidate[i]=Integer.parseInt(br.readLine());
			}
			int[] check=new int[t];
			int[] check2=new int[t];
			dijkstra(s);
			for(int i=0;i<t;i++) {
				check[i]=visit[candidate[i]];
			}
			int gCost=visit[g];
			int hCost=visit[h];
			dijkstra(g);
			int gCost2=visit[h];
			for(int i=0;i<t;i++) {
				check2[i]=visit[candidate[i]];
			}
			dijkstra(h);
			int hCost2=visit[g];
			for(int i=0;i<t;i++) {
				if(check[i]==(gCost+gCost2+visit[candidate[i]]) || check[i]==(hCost+hCost2+check2[i])) {
					ans.add(candidate[i]);
				}
			}
			Collections.sort(ans);
			for(int next:ans)sb.append(next+" ");
			sb.append("\n");
			ans.clear();
		}
		System.out.println(sb.toString());
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge>pq=new PriorityQueue<Edge>();
		for(int i=1;i<=n;i++) {
			visit[i]=Integer.MAX_VALUE;
		}
		visit[start]=0;
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
			
			if(cur.cost>visit[cur.node])continue;
			
			for(int i=0;i<adj[cur.node].size();i++) {
				Edge next=(Edge) adj[cur.node].get(i);
				
				if(visit[next.node]>cur.cost+next.cost) {
					visit[next.node]=cur.cost+next.cost;
					pq.add(new Edge(next.node,visit[next.node]));
				}
			}
		}
	}

}
