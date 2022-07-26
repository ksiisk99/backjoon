
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int[] fNum;
	static Map<String,Integer>map;
	
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	
	static int union(int n1,int n2) {
		n1=find(n1);
		n2=find(n2);
		if(n1==n2)return fNum[n1];
		
		if(n1<n2) {
			parent[n2]=n1;
			fNum[n1]+=fNum[n2];
			fNum[n2]=0;
			return fNum[n1];
		}
		parent[n1]=n2;
		fNum[n2]+=fNum[n1];
		fNum[n1]=0;
		return fNum[n2];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int F=Integer.parseInt(br.readLine());
			parent=new int[F*2+1];
			fNum=new int[F*2+1];
			map=new HashMap<String, Integer>();
			for(int i=1;i<(F*2+1);i++) {
				parent[i]=i;
				fNum[i]=1;
			}
			
			int idx=1;
			for(int i=0;i<F;i++) {
				st=new StringTokenizer(br.readLine());
				String f1=st.nextToken();
				String f2=st.nextToken();
				if(!map.containsKey(f1)) {
					map.put(f1, idx++);
				}
				if(!map.containsKey(f2)) {
					map.put(f2, idx++);
				}
				sb.append(union(map.get(f1),map.get(f2))+"\n");
			}
		}
		
		System.out.print(sb.toString());
	}

}
