import java.io.*;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] map=new int[N][M];
		boolean[][][] visit=new boolean[N][M][2];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		Queue<int[]>queue=new LinkedList<int[]>();
		queue.add(new int[] {0,0,1,0});
		
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				System.out.println(cur[2]);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx=cur[0]+dx[i];
				int ny=cur[1]+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
				int cnt=cur[2]+1;
				
				if(map[nx][ny]==0) {
					if(cur[3]==0 && !visit[nx][ny][0]) {
						queue.add(new int[] {nx,ny,cnt,0});
						visit[nx][ny][0]=true;
					}else if(cur[3]==1 && !visit[nx][ny][1]) {
						queue.add(new int[] {nx,ny,cnt,1});
						visit[nx][ny][1]=true;
					}
				}else {
					if(cur[3]!=1) {
						queue.add(new int[] {nx,ny,cnt,1});
						visit[nx][ny][1]=true;
					}
				}
			}
		}
		System.out.println(-1);
	}

}
