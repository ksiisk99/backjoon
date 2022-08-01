import java.io.*;
import java.util.*;



public class Main {
	static StringBuilder sb;
	static int N;
	static int[] parent;
	static Point[] pointArr;
	static List<Point> points=new ArrayList<Main.Point>();
	static List<Edge> edges=new ArrayList<Main.Edge>();
	
	static class Point{
		int n,x,y,z;

		public Point(int n,int x, int y, int z) {
			this.n=n;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int n1,n2,dist;

		public Edge(int n1, int n2, int dist) {
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
	
	static int distance(int x1,int y1, int z1, int x2,int y2,int z2) {
		return Math.min(Math.abs(z1-z2),  Math.min(Math.abs(x1-x2), Math.abs(y1-y2)));
	}
	
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	
	static void union(int n1,int n2) {
		if(n1!=n2)
			parent[n2]=n1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		parent=new int[N];
		pointArr=new Point[N];
		for(int i=0;i<N;i++) {
			parent[i]=i;
			st=new StringTokenizer(br.readLine());
			pointArr[i]=new Point(i,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(pointArr,(o1,o2)->o1.x-o2.x);
		for(int i=0;i<N-1;i++) {
			edges.add(new Edge(pointArr[i].n,pointArr[i+1].n,Math.abs(pointArr[i].x-pointArr[i+1].x)));
		}
		
		Arrays.sort(pointArr,(o1,o2)->o1.y-o2.y);
		for(int i=0;i<N-1;i++) {
			edges.add(new Edge(pointArr[i].n,pointArr[i+1].n,Math.abs(pointArr[i].y-pointArr[i+1].y)));
		}
		
		Arrays.sort(pointArr,(o1,o2)->o1.z-o2.z);
		for(int i=0;i<N-1;i++) {
			edges.add(new Edge(pointArr[i].n,pointArr[i+1].n,Math.abs(pointArr[i].z-pointArr[i+1].z)));
		}	
		Collections.sort(edges);
		
		long sum=0;
		for(int i=0;i<edges.size();i++) {
			int n1=find(edges.get(i).n1);
			int n2=find(edges.get(i).n2);
			if(n1!=n2) {
				union(n1,n2);
				sum+=(long)edges.get(i).dist;
			}
		}
		System.out.println(sum);
	}
	

}
