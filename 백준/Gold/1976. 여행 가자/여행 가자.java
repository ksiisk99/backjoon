import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int N,M;
	static int[][] arr;
	static int[] city;
	static int find(int x) {
		if(x==parent[x])
			return x;
		return parent[x]=find(parent[x]);
	}
	
	static void union(int n1,int n2) {
		n1=find(n1);
		n2=find(n2);
		if(n1>n2) {
			parent[n1]=n2;
			return;
		}
		parent[n2]=n1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
	
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		city=new int[M];
		arr=new int[N+1][N+1];
		parent=new int[N+1];
		for(int i=1;i<=N;i++)parent[i]=i;
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					union(i,j);
				}
			}
		}
		int tmp=0;
		st=new StringTokenizer(br.readLine());
		boolean check=true;
		for(int i=0;i<M;i++) {
			city[i]=Integer.parseInt(st.nextToken());
			if(i==0)tmp=find(city[i]);
			else {
				int n=find(city[i]);
				if(n!=tmp) {
					check=false;
					break;
				}
			}
		}
		if(check)System.out.println("YES");
		else System.out.println("NO");
	}

}
