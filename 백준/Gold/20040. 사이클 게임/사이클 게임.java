import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int N,M;
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
		}else
			parent[n1]=n2;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int[N];
		int i;
		for(i=0;i<N;i++) {
			parent[i]=i;
		}

		for(i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			if(union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))){
				System.out.println(i+1);
				break;
			}
		}
		if(i==M)System.out.println(0);
	}
}
