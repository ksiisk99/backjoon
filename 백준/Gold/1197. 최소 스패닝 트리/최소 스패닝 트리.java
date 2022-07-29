import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int N,M;
	static List<Node>adj;
	static int cost=0;
	
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	
	static void union(int n1,int n2) {
		if(n1<n2) {
			parent[n2]=n1;
			return;
		}
		parent[n1]=n2;
	}
	
	static class Node implements Comparable<Node>{
		int n1,n2,cost;

		public Node(int n1, int n2,int cost) {
			super();
			this.n1 = n1;
			this.n2=n2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return cost-o.cost;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());		
		M=Integer.parseInt(st.nextToken());
		adj=new ArrayList<Main.Node>();
		parent=new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;	
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			adj.add(new Node(n1,n2,cost));
		}		
		Collections.sort(adj);
		
		for(int i=0;i<M;i++) {
			int n1=find(adj.get(i).n1);
			int n2=find(adj.get(i).n2);
			if(n1!=n2) {
				union(n1,n2);
				cost+=adj.get(i).cost;
			}
		}
		System.out.println(cost);
	}
}
