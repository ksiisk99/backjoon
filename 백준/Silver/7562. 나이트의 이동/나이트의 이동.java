

import java.io.*;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int[] dx= {-1,-2,-2,-1,1,2,1,2};
		int[] dy= {-2,-1,1,2,-2,-1,2,1};
				
	
		Queue<int[]>queue=new LinkedList<>();
		
		
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int l=Integer.parseInt(br.readLine());
			int[][] visit=new int[l][l];
			for(int i=0;i<l;i++)Arrays.fill(visit[i], Integer.MAX_VALUE);
			
			st=new StringTokenizer(br.readLine());
			int curX=Integer.parseInt(st.nextToken());
			int curY=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int lastX=Integer.parseInt(st.nextToken());
			int lastY=Integer.parseInt(st.nextToken());
			queue.add(new int[] {curX,curY,0});
			visit[curX][curY]=0;
			while(!queue.isEmpty()) {
				int[] cur=queue.poll();
				for(int i=0;i<8;i++) {
					int nx=cur[0]+dx[i];
					int ny=cur[1]+dy[i];
					int cnt=cur[2]+1;
					
					if(nx<0 || ny<0 || nx>=l || ny>=l)continue;
					if(visit[cur[0]][cur[1]]+1<visit[nx][ny]) {
						visit[nx][ny]=visit[cur[0]][cur[1]]+1;
						queue.add(new int[] {nx,ny,cnt});
					}
				}
			}
			sb.append(visit[lastX][lastY]+"\n");
		}
		System.out.println(sb.toString());
		
	} 

}
