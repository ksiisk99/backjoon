
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	static int N,M;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		int caseNum=0;
		
		while(true) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			if(N==0 && M==0)break;
			caseNum++;
			list=new ArrayList[N+1];
			visit=new boolean[N+1];
			for(int i=1;i<=N;i++)list[i]=new ArrayList<Integer>();
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int n1=Integer.parseInt(st.nextToken());
				int n2=Integer.parseInt(st.nextToken());
				list[n1].add(n2);
				list[n2].add(n1);
			}
			
			int cnt=0;
			for(int i=1;i<=N;i++) {
				if(!visit[i]) {
					check=false;
					dfs(i,i);
					if(!check)cnt++;
				}
			}
			if(cnt!=0) {
				if(cnt==1)
					sb.append("Case "+caseNum+": There is one tree.\n");
				else
					sb.append("Case "+caseNum+": A forest of "+cnt+" trees.\n");
			}else{
				sb.append("Case "+caseNum+": No trees.\n");
			}
		}
		System.out.print(sb.toString());	
	}
	
	static void dfs(int start,int beforeNode) {
		visit[start]=true;
		for(int next:list[start]) {
			if(beforeNode==next) {
				continue;
			}
			if(!visit[next])dfs(next,start);
			else check=true;
		}
	}
	
}
