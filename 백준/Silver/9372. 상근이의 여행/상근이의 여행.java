import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	static boolean union(int n1,int n2) {
		n1=find(n1);
		n2=find(n2);
		if(n1==n2)return true;
		if(n1<n2) {
			parent[n2]=n1;
		}else {
			parent[n1]=n2;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			parent=new int[N+1];
			for(int i=1;i<=N;i++)parent[i]=i;
			int cnt=0;
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				if(!union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))) {
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.print(sb.toString());
	}

}
