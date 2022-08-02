import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	static int N,M;
	static int[] parent;
	static int[][] map;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static boolean[][] visit;
	static int num=0;
	static List<Edge>list;
	
	static class Edge implements Comparable<Edge>{
		int n1,n2,dist;

		public Edge(int n1, int n2, int dist) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return dist-o.dist;
		}
		
	}
	
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	
	static void union(int n1,int n2) {
		if(n1!=n2)
			parent[n2]=n1;
	}
	
	static void dfs(int x,int y,int num) {
		visit[x][y]=true;
		map[x][y]=num;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
			if(!visit[nx][ny] && map[nx][ny]==1)
				dfs(nx,ny,num);
		}
	}
	
	static void findIsland(int x, int y, int k, int num) {
		int cnt=1;
		int nx=x;
		int ny=y;
		while(true) {
			nx+=dx[k];
			ny+=dy[k];
			if(nx<0 || ny<0 || nx>=N || ny>=M)return;
			
			if(map[nx][ny]==0) {
				cnt++;
			}else if(map[nx][ny]!=num) {				
				if(cnt>=2) {
					list.add(new Edge(num,map[nx][ny],cnt));
				}
				return;
			}else {
				return;
			}
		}		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		list=new ArrayList<Edge>();
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j] && map[i][j]==1) {
					num++;
					dfs(i,j,num);
				}
			}
		}
		parent=new int[num+1];
		for(int i=1;i<=num;i++) {
			parent[i]=i;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0) {
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
						if(map[nx][ny]==0) {
							findIsland(nx,ny,k,map[i][j]);
						}
					}
				}
			}
		}
		
		Collections.sort(list);
		int sum=0;
		int cnt=0;
		for(Edge edge:list) {
			int n1=find(edge.n1);
			int n2=find(edge.n2);
			if(n1!=n2) {
				cnt++;
				union(n1,n2);
				sum+=edge.dist;
			}
		}
	
		System.out.println(cnt==(num-1)?sum:-1);
	}

	

}
