

import java.io.*;
import java.util.*;

public class Main {
	static int V,E,K;
	
	static class Edge implements Comparable<Edge>{
		int v,cost;
		
		public Edge(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}		
	}
	static ArrayList[] adjList;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine());
		dist=new int[V+1];
		adjList=new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			dist[i]=Integer.MAX_VALUE;
			adjList[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			adjList[u].add(new Edge(v,w));
		}
		dijkstra(K);
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE){
				sb.append("INF\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		dist[start]=0;
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now=pq.poll();
			if(now.cost>dist[now.v])continue;
			
			for(int i=0;i<adjList[now.v].size();i++) {
				Edge next=(Edge)adjList[now.v].get(i);
				
				if(dist[next.v]>now.cost+next.cost) {
					dist[next.v]=now.cost+next.cost;
					pq.add(new Edge(next.v,dist[next.v]));
				}
			}
		}
	}

}
