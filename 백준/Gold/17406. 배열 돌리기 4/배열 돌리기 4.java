import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	public static class RCS{
		int r;
		int c;
		int s;
		
		public RCS() {}
		public RCS(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		public int getR() {
			return r;
		}
		public int getC() {
			return c;
		}
		public int getS() {
			return s;
		}
	}
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static int K,N,M;
	static int[][] arr;
	static int[][] tmpArr;
	static int MIN=55000;
	static boolean[] visited;
	static RCS[] rcs;
	static Stack<Integer> st=new Stack<Integer>();
	
	public static void dfs(int cnt) {
		if(cnt==K) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					tmpArr[i][j]=arr[i][j];
				}
			}
			for(int k=0;k<K;k++) {
				int idx=st.get(k);
				int x1=rcs[idx].getR()-rcs[idx].getS();
				int x2=rcs[idx].getR()+rcs[idx].getS();
				int y1=rcs[idx].getC()-rcs[idx].getS();
				int y2=rcs[idx].getC()+rcs[idx].getS();
				int group=Math.min(x2-x1, y2-y1)/2;
				
				for(int i=0;i<group;i++) {
					int x=x1+i;
					int y=y2-i;
					int tmp=tmpArr[x][y];
					int rotate=0;
					
					while(true) {
						if(x+dx[rotate]>x2-i || x+dx[rotate]<x1+i || y+dy[rotate]>y2-i || y+dy[rotate]<y1+i)rotate++;
						if(rotate>3)break;
						tmpArr[x][y]=tmpArr[x+dx[rotate]][y+dy[rotate]];
						x=x+dx[rotate]; y=y+dy[rotate];
					}
					tmpArr[x1+i+1][y2-i]=tmp;
				}
			}
			for(int i=1;i<=N;i++) {
				int sum=0;
				for(int j=1;j<=M;j++) {
					sum+=tmpArr[i][j];
				}
				MIN=Math.min(sum, MIN);
			}
			return;
		}
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				st.add(i);
				visited[i]=true;
				dfs(cnt+1);
				visited[i]=false;
				st.pop();
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new int[N+1][M+1];
		tmpArr=new int[N+1][M+1];
		rcs=new RCS[K];
		visited=new boolean[K];
			
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			rcs[i]=new RCS(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		dfs(0);
		bw.write(String.valueOf(MIN));
		bw.flush();
	}
}

