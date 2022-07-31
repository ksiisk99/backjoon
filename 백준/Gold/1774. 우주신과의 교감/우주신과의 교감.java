
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int N,M;
	static int[] parent;
	static List<Coordinate>coordinateList;
	static List<Node>list;
	
	static class Coordinate{
		double x,y;

		public Coordinate(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node implements Comparable<Node>{
		int n1, n2;
		double dist;
		
		public Node(int n1, int n2, double dist) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(dist>o.dist)
				return 1;
			return -1;
		}		
	}
	
	static double dist(double x1,double y1, double x2,double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
	
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
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		coordinateList=new ArrayList<Coordinate>();
		list=new ArrayList<Node>();
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parent=new int[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			double x=Double.parseDouble(st.nextToken());
			double y=Double.parseDouble(st.nextToken());
			coordinateList.add(new Coordinate(x,y));
		}
		for(int i=0;i<N;i++) {parent[i]=i;}
		
		double result=0;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int n1=find(Integer.parseInt(st.nextToken())-1);
			int n2=find(Integer.parseInt(st.nextToken())-1);
			union(n1,n2);
		}
			
		
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				list.add(new Node(i,j,
						dist(coordinateList.get(i).x,coordinateList.get(i).y
								,coordinateList.get(j).x,coordinateList.get(j).y)));
			}
		}
		
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			int n1=find(list.get(i).n1);
			int n2=find(list.get(i).n2);
			if(n1!=n2) {
				union(n1,n2);
				result+=list.get(i).dist;
			}
		}
		System.out.println(String.format("%.2f", result));
		
	}
}
