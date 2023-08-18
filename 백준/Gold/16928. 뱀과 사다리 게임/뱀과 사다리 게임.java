
import java.io.*;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int[] dx= {1,2,3,4,5,6};
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] ladder=new int[101];
		int[] snake=new int[101];
		int[] visit=new int[101];
		Arrays.fill(visit, Integer.MAX_VALUE);
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			ladder[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			snake[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer>queue=new LinkedList<Integer>();
		queue.add(1);
		visit[1]=0;
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			for(int i=0;i<6;i++) {
				int next=cur+dx[i];
				if(next>100)break;
				if(ladder[next]>0) {
					if(visit[cur]+1<visit[ladder[next]]) {
						visit[ladder[next]]=visit[cur]+1;
						queue.add(ladder[next]);
					}
				}else if(snake[next]>0) {
					if(visit[cur]+1<visit[snake[next]]) {
						visit[snake[next]]=visit[cur]+1;
						queue.add(snake[next]);
					}
				}else if(visit[cur]+1<visit[next]) {
					visit[next]=visit[cur]+1;
					queue.add(next);
				}
			}
		}
		System.out.println(visit[100]);
	} 

}
