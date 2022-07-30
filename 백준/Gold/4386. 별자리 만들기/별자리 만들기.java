import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int N;
	static int[] parent;
	static List<Coordinate>coordinateList;
	static List<Node>list;
	
	static class Coordinate{
		double x,y;
		public Coordinate(double x, double y) {
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
			return (int) (dist-o.dist);
		}		
	}
	
	static double dist(double x1,double y1,double x2, double y2) {
		double x=Math.pow((Math.abs(x2-x1)), 2);
		double y=Math.pow((Math.abs(y2-y1)), 2);
		return Math.sqrt(x+y);
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
		
		N=Integer.parseInt(br.readLine());
		int size=(N)*(N-1)/2;
		parent=new int[size];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			double x=Double.parseDouble(st.nextToken());
			double y=Double.parseDouble(st.nextToken());
			coordinateList.add(new Coordinate(x,y));
		}
		for(int i=0;i<size;i++) {parent[i]=i;}
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				list.add(new Node(i,j,
						dist(coordinateList.get(i).x,coordinateList.get(i).y
								,coordinateList.get(j).x,coordinateList.get(j).y)));
			}
		}
		double result=0;
		Collections.sort(list);
		for(int i=0;i<size;i++) {
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
