

import java.io.*;
import java.util.*;




public class Main {
	static int N,M;
	static StringBuilder sb;
	static int[][] map;
	static int[][] floyd;
	static int[][] path;
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		floyd=new int[N+1][N+1];
		path=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(map[i], 1000000000);
			map[i][i]=0;
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			map[a][b]=Math.min(map[a][b], c);
			path[a][b]=a;
		}
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					//map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
					if(i==j)continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
						path[i][j]=path[k][j];
					}
				}
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j]==1000000000) {
					sb.append("0 ");
				}else sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)sb.append("0\n");
				else {
					Stack<Integer> stack=new Stack<>();
					int idx=path[i][j];
					while(idx!=0) {
						stack.push(idx);
						idx=path[i][idx];
					}
					if(stack.isEmpty()) {
						sb.append("0\n");
					}else {
						sb.append(stack.size()+1+" ");
						while(!stack.isEmpty()) {
							sb.append(stack.pop()+" ");
						}
						sb.append(j+"\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
