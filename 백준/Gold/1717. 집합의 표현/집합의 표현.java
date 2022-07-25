
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int N,M;
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
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		for(int i=1;i<=N;i++)parent[i]=i;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int z=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(z==0) {
				union(a,b);
			}else {
				a=find(a);
				b=find(b);
				if(a==b)sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}

}
