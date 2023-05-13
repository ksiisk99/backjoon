import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static int[][] arr;
	static int[][] dp;
	static int N,M;
	static int cnt=0;
	
	static int dfs(int x,int y) {

		if(x==(N-1) && y==(M-1)) {
			return 1;
		}
		if(dp[x][y]!=-1)return dp[x][y];
		dp[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=N || ny<0 || ny>=M || nx<0)continue;
			if(arr[x][y]<=arr[nx][ny])continue;
			dp[x][y]+=dfs(nx,ny);
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		dp=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		
		System.out.println(dfs(0,0));
		
	}
}